package com.hieuminh.jobfinder.views.fragments

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.ActivityResult
import com.bumptech.glide.Glide
import com.google.gson.JsonObject
import com.hieuminh.jobfinder.common.enums.FileExtension
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.gone
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.onClick
import com.hieuminh.jobfinder.common.extensions.ViewExtensions.visible
import com.hieuminh.jobfinder.databinding.FragmentInputProfileBinding
import com.hieuminh.jobfinder.models.ApplicantProfile
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.presenters.MediaContract
import com.hieuminh.jobfinder.presenters.UserContracts
import com.hieuminh.jobfinder.presenters.impl.MediaPresenterImpl
import com.hieuminh.jobfinder.presenters.impl.UserPresenterImpl
import com.hieuminh.jobfinder.utils.CustomActivityResult
import com.hieuminh.jobfinder.utils.ImageUtils
import com.hieuminh.jobfinder.utils.PermissionUtils
import com.hieuminh.jobfinder.views.activity.base.BaseActivity
import com.hieuminh.jobfinder.views.fragments.base.BaseAdvanceFragment


class InputProfileFragment : BaseAdvanceFragment<OnBoardingNavigator, UserContracts.ProfileContract.Presenter, FragmentInputProfileBinding>(),
    UserContracts.ProfileContract.View, MediaContract.View {
    private val provinceMap = mapOf<String, String>()
    private var mediaPresenter: MediaContract.Presenter? = null
    private var currentProvinceCode: String? = null
    private var currentAvatarUrl: String? = null

    private val applicantProfile: ApplicantProfile
        get() = ApplicantProfile(
            currentAvatarUrl,
            binding?.evFullName?.text,
            binding?.evDayOfBirth?.text,
            currentProvinceCode,
            binding?.evAddress?.text,
            binding?.pvOccupation?.text,
        )

    override fun getViewBinding() = FragmentInputProfileBinding.inflate(layoutInflater)

    override fun getPresenter() = UserPresenterImpl.ProfilePresenterImpl(this)

    override fun getNavigator() = OnBoardingNavigatorImpl(view)

    private fun uploadImage() {
        val dialogBuilder = AlertDialog.Builder(context)
        val types = arrayListOf("From camera", "From gallery")
        dialogBuilder.setTitle("Pick a image:")
        dialogBuilder.setItems(types.toTypedArray()) { dialog, which ->
            dialog.dismiss()
            when (which) {
                0 -> uploadImageFromCamera()
                1 -> uploadImageFromGallery()
            }
        }
        dialogBuilder.show()
    }

    private fun uploadImageFromCamera() {
        if (PermissionUtils.isRequirePermission(
                context as Activity?,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                0,
            )
        ) {
            return
        }
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file = ImageUtils.createImageFile(context)
        takePicture.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file))
        (activity as? BaseActivity<*>)?.activityLauncher()?.launch(
            takePicture,
            object : CustomActivityResult.OnActivityResult<ActivityResult> {
                override fun onActivityResult(result: ActivityResult) {
                    if (result.resultCode == Activity.RESULT_OK) {
                        //  TODO
                    }
                }
            })
    }

    private fun uploadImageFromGallery() {
        val mimeTypes = arrayOf(
            FileExtension.JPG,
            FileExtension.PNG,
            FileExtension.JPEG,
        ).map { ".".plus(it.value) }.toTypedArray()
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "*/*"
        }
        (activity as? BaseActivity<*>)?.activityLauncher()?.launch(
            intent,
            object : CustomActivityResult.OnActivityResult<ActivityResult> {
                override fun onActivityResult(result: ActivityResult) {
                    if (result.resultCode == Activity.RESULT_OK) {
                        mediaPresenter?.uploadFile(result.data?.data ?: return)
                    }
                }
            })
    }

    private fun submitProfile() {
        mPresenter?.createProfile(applicantProfile)
    }

    override fun initListener() {
        binding?.llAvatarUpload?.onClick { uploadImage() }
        binding?.ivAvatar?.onClick { uploadImage() }
        binding?.btSubmit?.onClick { submitProfile() }
    }

    override fun initView() {
        mediaPresenter = MediaPresenterImpl(this)
    }

    override fun createProfileSuccess(jsonObject: JsonObject?) {
    }

    override fun onUploadFileSuccess(url: String?) {
        binding?.ivAvatar?.let { Glide.with(this).load(url).into(it) }
        binding?.ivAvatar?.visible()
        binding?.llAvatarUpload?.gone()
    }

    override fun onFailure(errorMessage: String, code: Int?) {
    }
}

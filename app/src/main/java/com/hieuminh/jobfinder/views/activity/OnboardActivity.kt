package com.hieuminh.jobfinder.views.activity

import android.view.View
import androidx.navigation.fragment.findNavController
import com.hieuminh.jobfinder.R
import com.hieuminh.jobfinder.databinding.ActivityOnboardBinding
import com.hieuminh.jobfinder.navigators.OnBoardingNavigator
import com.hieuminh.jobfinder.navigators.OnBoardingNavigatorImpl
import com.hieuminh.jobfinder.views.activity.base.BaseActivity

class OnboardActivity : BaseActivity<ActivityOnboardBinding>() {
    override fun getViewBinding() = ActivityOnboardBinding.inflate(layoutInflater)

    private val loginWithFacebookClickListener = View.OnClickListener {

    }

    private val loginWithGoogleClickListener = View.OnClickListener {

    }

    override fun initListener() {
    }

    fun getNavigator(view: View?): OnBoardingNavigator {
        return OnBoardingNavigatorImpl(view)
    }

    override fun initView() {
    }
}

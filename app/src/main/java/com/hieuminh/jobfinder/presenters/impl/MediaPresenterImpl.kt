package com.hieuminh.jobfinder.presenters.impl

import android.net.Uri
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.hieuminh.jobfinder.presenters.MediaContract
import com.hieuminh.jobfinder.presenters.base.BasePresenterImpl
import java.io.File
import java.io.FileInputStream
import java.time.LocalDateTime


class MediaPresenterImpl(private val view: MediaContract.View?) : BasePresenterImpl(view), MediaContract.Presenter {
    private val firebaseStorage = Firebase.storage

    override fun uploadFile(file: File) {
        view?.startLoading()
        val stream = FileInputStream(file)
        firebaseStorage.reference.putStream(stream).addOnSuccessListener { snapShot ->
            view?.endLoading()
            view?.onUploadFileSuccess(snapShot?.uploadSessionUri?.path)
        }.addOnFailureListener { exception ->
            view?.endLoading()
            view?.onFailure(exception.message ?: "")
        }
    }

    override fun uploadFile(uri: Uri) {
        view?.startLoading()
        val reference = firebaseStorage.reference.child("images/avt_${LocalDateTime.now()}.png")
        reference.putFile(uri).addOnSuccessListener {
            reference.downloadUrl.addOnSuccessListener {
                view?.endLoading()
                view?.onUploadFileSuccess(it.toString())
            }
        }.addOnFailureListener { exception ->
            view?.endLoading()
            view?.onFailure(exception.message ?: "")
        }
    }
}
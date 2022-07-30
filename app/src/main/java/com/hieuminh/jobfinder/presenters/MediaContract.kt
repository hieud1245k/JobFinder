package com.hieuminh.jobfinder.presenters

import android.net.Uri
import com.hieuminh.jobfinder.presenters.base.BasePresenter
import com.hieuminh.jobfinder.presenters.base.BaseView
import java.io.File

interface MediaContract {
    interface Presenter: BasePresenter {
        fun uploadFile(file: File)
        fun uploadFile(uri: Uri)
    }

    interface View: BaseView {
        fun onUploadFileSuccess(url: String?)
    }
}
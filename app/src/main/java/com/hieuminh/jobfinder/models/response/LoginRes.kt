package com.hieuminh.jobfinder.models.response

import com.google.gson.annotations.SerializedName
import com.hieuminh.jobfinder.models.base.BaseModel

class LoginRes: BaseModel() {

    @SerializedName("access_token")
    var accessToken: String? = null
}

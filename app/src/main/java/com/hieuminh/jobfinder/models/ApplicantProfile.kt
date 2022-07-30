package com.hieuminh.jobfinder.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.jobfinder.models.base.BaseModel

data class ApplicantProfile(
    @SerializedName("avatarUrl")
    @Expose
    var avatarUrl: String? = null,

    @SerializedName("fullName")
    @Expose
    var fullName: String? = null,

    @SerializedName("provinceCode")
    @Expose
    var provinceCode: String? = null,

    @SerializedName("address")
    @Expose
    var address: String? = null,

    @SerializedName("dayOfBirth")
    @Expose
    var dayOfBirth: String? = null,

    @SerializedName("occupation")
    @Expose
    var occupation: String? = null,
) : BaseModel()

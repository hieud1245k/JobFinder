package com.hieuminh.jobfinder.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.jobfinder.models.base.BaseModel
import java.util.*

data class Message(
    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("from_user_id")
    @Expose
    var fromUserId: Int? = null,

    @SerializedName("to_user_id")
    @Expose
    var toUserId: Int? = null,

    @SerializedName("created_date")
    @Expose
    var createdDate: Date? = Calendar.getInstance().time,
) : BaseModel()

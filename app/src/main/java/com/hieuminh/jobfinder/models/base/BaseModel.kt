package com.hieuminh.jobfinder.models.base

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.hieuminh.jobfinder.utils.JsonUtils
import java.io.Serializable

abstract class BaseModel : Serializable {
    @SerializedName("id")
    @Expose
    val id: Int? = null

    fun toJson(): String {
        return JsonUtils.toJson(this)
    }

    inline fun <reified T> clone(): T? {
        return JsonUtils.fromJson(this.toJson())
    }
}

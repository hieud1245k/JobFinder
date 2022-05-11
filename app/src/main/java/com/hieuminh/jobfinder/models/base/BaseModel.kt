package com.hieuminh.jobfinder.models.base

import com.hieuminh.jobfinder.utils.JsonUtils
import java.io.Serializable

abstract class BaseModel : Serializable {
    fun toJson(): String {
        return JsonUtils.toJson(this)
    }

    inline fun <reified T> clone(): T? {
        return JsonUtils.fromJson(this.toJson())
    }
}

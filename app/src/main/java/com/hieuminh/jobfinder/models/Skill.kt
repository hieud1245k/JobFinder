package com.hieuminh.jobfinder.models

import com.hieuminh.jobfinder.models.base.BaseModel

data class Skill(
    var name: String? = null,
    var isSelected: Boolean = false,
) : BaseModel()

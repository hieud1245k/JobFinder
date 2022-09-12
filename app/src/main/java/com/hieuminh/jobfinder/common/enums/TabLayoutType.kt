package com.hieuminh.jobfinder.common.enums

import com.hieuminh.jobfinder.R

enum class TabLayoutType(val nameResId: Int, val iconResId: Int) {
    HOME(R.string.home, R.drawable.ic_baseline_home_24),
    APPLICATIONS(R.string.applications, R.drawable.ic_menu_application),
    CHAT(R.string.chat, R.drawable.ic_baseline_chat_24),
    PROFILE(R.string.profile, R.drawable.ic_baseline_person_24),
}

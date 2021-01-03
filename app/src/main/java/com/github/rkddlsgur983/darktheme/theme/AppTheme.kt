package com.github.rkddlsgur983.darktheme.theme

import android.content.Context
import com.github.rkddlsgur983.darktheme.sharedpreference.BaseSharedPreference

class AppTheme(context: Context) : BaseSharedPreference<Int>(context,
    name = SHARED_PREFERENCE_NAME,
    key = KEY,
    defValue = DEFAULT
) {
    companion object {
        const val KEY = "APP_THEME_KEY"
        const val DEFAULT = 0
        const val LIGHT = 1
        const val DARK = 2
    }
}

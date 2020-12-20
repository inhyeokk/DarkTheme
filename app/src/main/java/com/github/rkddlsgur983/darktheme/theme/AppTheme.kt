package com.github.rkddlsgur983.darktheme.theme

import android.content.Context
import com.github.rkddlsgur983.darktheme.Const
import com.github.rkddlsgur983.darktheme.sharedpreference.BaseSharedPreference

class AppTheme(context: Context) : BaseSharedPreference<Int>(context,
    Const.SHARED_PREFERENCE_NAME, KEY, DEFAULT
) {
    companion object {
        const val KEY = "APP_THEME_KEY"
        const val DEFAULT = 0
        const val LIGHT = 1
        const val DARK = 2
    }
}

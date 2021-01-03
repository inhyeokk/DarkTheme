package com.github.rkddlsgur983.darktheme.util

import android.content.Context
import com.github.rkddlsgur983.darktheme.theme.AppTheme

object SharedPreferenceManager {

    private lateinit var appTheme: AppTheme

    fun init(context: Context) {
        appTheme = AppTheme(context)
    }

    fun getAppTheme(): Int {
        return appTheme.value
    }

    fun setAppTheme(value: Int) {
        appTheme.value = value
    }
}

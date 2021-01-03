package com.github.rkddlsgur983.darktheme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.theme.ThemeUtil
import com.github.rkddlsgur983.darktheme.util.SharedPreferenceManager

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceManager.init(applicationContext)
        AppCompatDelegate.setDefaultNightMode(ThemeUtil.getAppTheme())
    }
}

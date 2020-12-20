package com.github.rkddlsgur983.darktheme

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.sharedpreference.SharedPreferenceManager

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceManager.init(applicationContext)
        AppCompatDelegate.setDefaultNightMode(SharedPreferenceManager.getAppTheme())
    }
}

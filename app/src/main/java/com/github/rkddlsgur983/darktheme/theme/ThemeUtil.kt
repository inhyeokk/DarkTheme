package com.github.rkddlsgur983.darktheme.theme

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.util.SdkVersion
import com.github.rkddlsgur983.darktheme.util.SharedPreferenceManager

object ThemeUtil {

    fun getAppTheme() = when (SharedPreferenceManager.getAppTheme()) {
        AppTheme.LIGHT -> {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppTheme.DARK -> {
            AppCompatDelegate.MODE_NIGHT_YES
        }
        else -> { // DEFAULT or else
            if (isSupportSystemNightMode()) {
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            } else {
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }
        }
    }

    /**
     * 다크모드 지원 버전
     * 1. 10 이상
     * 2. 9 + 삼성 단말 (One UI 1.0에서 자체적으로 다크 모드를 지원함)
     */
    private fun isSupportSystemNightMode(): Boolean {
        return SdkVersion.isOverThanQ() || (SdkVersion.isOverThanPie() && isSamSungMobile())
    }

    private fun isSamSungMobile(): Boolean {
        return "SAMSUNG".equals(Build.MANUFACTURER, ignoreCase = true)
    }

}

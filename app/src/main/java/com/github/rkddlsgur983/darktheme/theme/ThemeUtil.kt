package com.github.rkddlsgur983.darktheme.theme

import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import com.github.rkddlsgur983.darktheme.util.SdkVersion
import com.github.rkddlsgur983.darktheme.sharedpreference.SharedPreferenceManager

object ThemeUtil {

    fun getInAppThemeMode() = when (SharedPreferenceManager.getAppTheme()) {
        AppTheme.LIGHT -> {
            AppCompatDelegate.MODE_NIGHT_NO
        }
        AppTheme.DARK -> {
            AppCompatDelegate.MODE_NIGHT_YES
        }
        else -> {
            if (isSupportSystemNightMode()) {
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            } else {
                AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
            }
        }
    }

    private fun isSupportSystemNightMode(): Boolean = SdkVersion.isQOrAbove() || isSupportSystemNightModeBelow10()

    // 예외적으로 안드로이드 P + 삼성 단말의 경우, OS 자체에서 다크 모드를 지원함
    private fun isSupportSystemNightModeBelow10(): Boolean {
        return SdkVersion.isPieOrAbove() && isSamSungMobile()
    }

    private fun isSamSungMobile(): Boolean {
        return "SAMSUNG".equals(Build.MANUFACTURER, ignoreCase = true)
    }
}

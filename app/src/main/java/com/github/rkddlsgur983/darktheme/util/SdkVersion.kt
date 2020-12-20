package com.github.rkddlsgur983.darktheme.util

import android.os.Build

object SdkVersion {
    /**
     * @return SDK_INT >= 29
     */
    fun isPieOrAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.P
    }

    /**
     * @return SDK_INT >= 29
     */
    fun isQOrAbove(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q
    }

}

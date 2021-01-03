package com.github.rkddlsgur983.darktheme.util

import android.app.Activity
import android.util.Log

object Logger {

    fun printLifeCycleLog(activity: Activity, methodName: String) {
        Log.d(activity.javaClass.simpleName, methodName)
    }
}
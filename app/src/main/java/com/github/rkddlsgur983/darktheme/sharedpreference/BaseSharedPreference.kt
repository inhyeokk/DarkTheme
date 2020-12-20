package com.github.rkddlsgur983.darktheme.sharedpreference

import android.content.Context
import android.content.SharedPreferences

open class BaseSharedPreference<T: Any>(context: Context, name: String, val key: String, private val defValue: T) {

    val prefs: SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    var value: T
        get() = prefs.get(key, defValue)
        set(value) = prefs.set(key, value)
}

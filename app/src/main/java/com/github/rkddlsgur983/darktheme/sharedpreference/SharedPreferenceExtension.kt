package com.github.rkddlsgur983.darktheme.sharedpreference

import android.content.SharedPreferences
import androidx.core.content.edit
import java.lang.UnsupportedOperationException

/**
 * 아래의 형변환은
 * @param defValue 의 자료형이 인자로 전달되고
 * is 연산 후 반환 자료형이 T와 같으므로 정확합니다.
 */
@Suppress("UNCHECKED_CAST")
fun <T: Any> SharedPreferences.get(key: String, defValue: T) = when (defValue) {
    is Boolean -> getBoolean(key, defValue) as T
    is Float -> getFloat(key, defValue) as T
    is Int -> getInt(key, defValue) as T
    is Long -> getLong(key, defValue) as T
    is String -> getString(key, defValue) as T
    else -> throw UnsupportedOperationException()
}

fun <T: Any> SharedPreferences.set(key: String, value: T) {
    when (value) {
        is Boolean -> edit { putBoolean(key, value) }
        is Float -> edit { putFloat(key, value) }
        is Int -> edit { putInt(key, value) }
        is Long -> edit { putLong(key, value) }
        is String -> edit { putString(key, value) }
        else -> throw UnsupportedOperationException()
    }
}

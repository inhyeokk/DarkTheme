package com.github.rkddlsgur983.darktheme.sharedpreference

import android.content.SharedPreferences
import androidx.lifecycle.LiveData

class SharedPreferenceLiveData<T: Any>(
    private val base: BaseSharedPreference<T>
) : LiveData<T>() {

    private val changeListener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
        if (key == base.key) {
            value = base.value
        }
    }

    override fun onActive() {
        super.onActive()
        value = base.value
        base.prefs.registerOnSharedPreferenceChangeListener(changeListener)
    }

    override fun onInactive() {
        base.prefs.unregisterOnSharedPreferenceChangeListener(changeListener)
        super.onInactive()
    }
}

fun <T: Any> BaseSharedPreference<T>.toPreferenceLiveData(): SharedPreferenceLiveData<T> {
    return SharedPreferenceLiveData(this)
}

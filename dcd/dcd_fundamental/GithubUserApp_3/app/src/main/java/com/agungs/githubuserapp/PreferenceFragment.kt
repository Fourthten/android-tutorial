package com.agungs.githubuserapp

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference

class PreferenceFragment: PreferenceFragmentCompat(), SharedPreferences.OnSharedPreferenceChangeListener {
    private lateinit var REMINDER: String
    private lateinit var reminderPreference: SwitchPreference

    private lateinit var alarmReceiver: AlarmReminder

    companion object {
        private const val DEFAULT_VALUE = "Tidak Ada"
    }

    override fun onCreatePreferences(bundle: Bundle?, s: String?) {
        addPreferencesFromResource(R.xml.preferences)
        init()
        setSummaries()
    }

    private fun init() {
        REMINDER = resources.getString(R.string.reminder)
        reminderPreference = findPreference<SwitchPreference>(REMINDER) as SwitchPreference
    }

    override fun onResume() {
        super.onResume()
        preferenceScreen.sharedPreferences.registerOnSharedPreferenceChangeListener(this)
    }
    override fun onPause() {
        super.onPause()
        preferenceScreen.sharedPreferences.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences, key: String?) {
        if (key == REMINDER) {
            reminderPreference.isChecked = sharedPreferences.getBoolean(REMINDER, false)
        }
    }

    private fun setSummaries() {
        alarmReceiver = AlarmReminder()
        val sh = preferenceManager.sharedPreferences
        reminderPreference.isChecked = sh.getBoolean(REMINDER, false)
    }
}
package com.agungs.githubuserapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.preference.SwitchPreference
import com.agungs.githubuserapp.databinding.ActivitySettingAlarmBinding


class SettingAlarm : AppCompatActivity() {
    private var binding: ActivitySettingAlarmBinding? = null
    private lateinit var alarmReceiver: AlarmReminder
    private lateinit var reminder: Button
    private lateinit var unreminder: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingAlarmBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        alarmReceiver = AlarmReminder()

        supportFragmentManager.beginTransaction().replace(R.id.setting_alarm, PreferenceFragment()).commit()
        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        sharedPreferences.registerOnSharedPreferenceChangeListener { sharedPreferences, key ->
            var isChecked = sharedPreferences.getBoolean(resources.getString(R.string.reminder), false)
            if(isChecked){
                alarmReceiver.setRepeatingAlarm(this)
            } else {
                alarmReceiver.cancelAlarm(this)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        binding = null
    }

    override fun onSupportNavigateUp(): Boolean {
        val moveFavorites = Intent(this@SettingAlarm, MainActivity::class.java)
        startActivity(moveFavorites)
        return true
    }
}
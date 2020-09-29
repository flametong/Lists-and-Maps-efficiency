package com.example.listsandmapsefficiency.repository

import android.content.Context
import android.content.SharedPreferences
import com.example.listsandmapsefficiency.App
import com.example.listsandmapsefficiency.util.Constants

class CustomSharedPreferences {

    private val sharedPref = App.context.getSharedPreferences(
        Constants.TABLE_PREFERENCES,
        Context.MODE_PRIVATE)

    private val editor = sharedPref.edit()

    fun saveData(key: String, value: String) {
        editor.putString(key, value)
            .apply()
    }

    fun loadData(key: String): String? =
        sharedPref.getString(key, "")

    fun registerPref(listener: SharedPreferences.OnSharedPreferenceChangeListener) {
        sharedPref.registerOnSharedPreferenceChangeListener(listener)
    }
}
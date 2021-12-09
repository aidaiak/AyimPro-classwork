package com.aid.pro

import android.app.Application

class App : Application() {
    val prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)
    val editor = prefs.edit()

    companion object {
        const val KEY_LOGIN = "key1"
        const val KEY_PWD = "key2"
    }
}
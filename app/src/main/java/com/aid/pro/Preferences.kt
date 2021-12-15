package com.aid.pro

import android.content.Context

interface Preferences {
    fun saveString(key: String, value: String)

    fun saveLogin(login: String)

    fun savePwd(pwd: String)

    fun getLogin(key: String): String

    fun getPwd(key: String): String

}

class PreferencesImpl(context: Context) : Preferences {
    private val preferences = context.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

    override fun saveString(key: String, value: String) {
        preferences.edit().apply() {
            putString(key, value)
        }.apply()
    }

    override fun saveLogin(login: String) {
        preferences.edit().apply {
            putString(KEY_LOGIN, login)
        }.apply()
    }

    override fun savePwd(pwd: String) {
        preferences.edit().apply {
            putString(KEY_PWD, pwd)
        }.apply()
    }

    override fun getLogin(key: String): String {
        return preferences.getString("KEY_LOGIN", "") ?: ""
    }

    override fun getPwd(key: String): String {
        return preferences.getString("KEY_PWD", "") ?: ""
    }

    companion object {
        private const val KEY_LOGIN = "KEY_LOGIN"
        private const val KEY_PWD = "KEY_PWD"
    }
}
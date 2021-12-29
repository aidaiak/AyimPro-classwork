package com.aid.pro

import android.content.Context

interface Preferences {
    fun changePrefs(login: String, pwd: String)
    fun checkPrefs(login: String, pwd: String)
}
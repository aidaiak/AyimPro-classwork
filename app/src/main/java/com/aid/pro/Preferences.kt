package com.aid.pro

interface Preferences {
    fun changePrefs(login: String, pwd: String)
    fun checkPrefs(login: String, pwd: String)
}
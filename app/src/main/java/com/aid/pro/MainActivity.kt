package com.aid.pro

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity(), Preferences {
    private lateinit var prefs: SharedPreferences
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPreferences(MODE_PRIVATE)
        prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        if (prefs.getString("login", "def").isNullOrEmpty()) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoginFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, SignupFragment())
                .commit()
        }
    }

    override fun changePrefs(login: String, pwd: String) {
        val editor = prefs.edit()
        editor.putString("login", login).apply()
        editor.putString("pwd", pwd).apply()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LoginFragment())
            .commit()

        Toast.makeText(this, "New login & password are set", Toast.LENGTH_SHORT).show()

    }

    override fun checkPrefs(login: String, pwd: String) {
        val trueLogin = prefs.getString("login", "def")
        val truePwd = prefs.getString("pwd", "def")

        if (trueLogin == login && truePwd == pwd) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .addToBackStack(null)
                .commit()
        } else if (count == 3) {
            val regBtn = findViewById<AppCompatButton>(R.id.reg_btn)
            regBtn.visibility = View.VISIBLE
            regBtn.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SignupFragment())
                    .commit()
            }
            count = 1
        } else {
            Toast.makeText(this, "Incorrect login or password", Toast.LENGTH_SHORT).show()
            count++
        }
    }
}


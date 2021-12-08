package com.aid.pro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aid.pro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE)

            txt.text = prefs.getString("key", "defValue")

            btn.setOnClickListener {
                val editor = prefs.edit()
                editor.putString("key", edit.text.toString())
                editor.apply()
            }
        }
    }
}
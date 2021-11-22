package com.aid.pro

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity1: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val txt = findViewById<TextView>(R.id.txt)
        val item = intent.getStringExtra("text")
        txt.text = item
    }
}
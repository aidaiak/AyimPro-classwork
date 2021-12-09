package com.aid.pro

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import android.content.SharedPreferences

//здесь будет экран Логина
class Fragment1 : Fragment(R.layout.fragment_1), App(prefs) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.llog_edit)
        val pwd = view.findViewById<AppCompatEditText>(R.id.lpwd_edit)
        val btnLog = view.findViewById<AppCompatButton>(R.id.log_btn)
        val btnReg = view.findViewById<AppCompatButton>(R.id.lreg_btn)

        val editor = prefs.edit()
        editor.putString(KEY_LOGIN, login.text.toString())

        btnLog.setOnClickListener {
            if(login.text.toString() ==  &&) {

            }
            val editor = prefs.edit()
            editor.putString(KEY_LOGIN, login.text.toString())
            editor.putString(KEY_PWD, pwd.text.toString())
            editor.apply()

        }

        btnReg.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, Fragment2())
                .addToBackStack(null)
                .commit()
        }
    }


}
package com.aid.pro

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

//здесь будет Экран регистрации
class Fragment2: Fragment(R.layout.fragment_2) {

    private val preferences get() = Injector.preferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rlogin = view.findViewById<AppCompatEditText>(R.id.rlog_edit)
        val rpwd = view.findViewById<AppCompatEditText>(R.id.rpwd_edit)
        val btn = view.findViewById<AppCompatButton>(R.id.reg_btn)

        btn.setOnClickListener {
            preferences.saveString(KEY_LOGIN, rlogin.text.toString())
            preferences.saveString(KEY_PWD, rpwd.text.toString())
        }
    }

    companion object {
        const val KEY_LOGIN = "KEY_LOGIN"
        const val KEY_PWD = "KEY_PWD"
    }
}
package com.aid.pro

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlin.math.log

//здесь будет экран Логина
class LoginFragment : Fragment(R.layout.login) {
    private lateinit var listener: Preferences
    private var pwdNotEmpty = false
    private var loginNotEmpty = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Preferences
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.llog_edit)
        val pwd = view.findViewById<AppCompatEditText>(R.id.lpwd_edit)
        val btnLog = view.findViewById<AppCompatButton>(R.id.log_btn)

        login.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    loginNotEmpty = false
                } else {
                    if (pwdNotEmpty) {
                        btnLog.isEnabled = true
                    }
                    loginNotEmpty = true
                }
            }
        })
        pwd.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    pwdNotEmpty = true
                } else {
                    if (loginNotEmpty) {
                        btnLog.isEnabled = true
                    }
                    pwdNotEmpty = true
                }
            }
        })
        btnLog.setOnClickListener {
            listener.checkPrefs(login.text.toString(), pwd.text.toString())
        }

    }

}
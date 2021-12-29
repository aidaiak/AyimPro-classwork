package com.aid.pro

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

//здесь будет Экран регистрации
class SignupFragment: Fragment(R.layout.signup) {
    private lateinit var listener: Preferences
    private var pwdNotEmpty = false
    private var loginNotEmpty = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Preferences
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rlogin = view.findViewById<AppCompatEditText>(R.id.rlog_edit)
        val rpwd = view.findViewById<AppCompatEditText>(R.id.rpwd_edit)
        val btn = view.findViewById<AppCompatButton>(R.id.reg_btn)

       rlogin.addTextChangedListener(object : TextWatcher {
           override fun afterTextChanged(p0: Editable?) {}
           override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {}
           override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
               if (p0.isNullOrEmpty()) {
                   loginNotEmpty = false
               } else {
                   if (pwdNotEmpty) {
                       btn.isEnabled = true
                   }
                   loginNotEmpty = true
               }
           }
       })

        rpwd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    pwdNotEmpty = false
                } else {
                    if (loginNotEmpty) {
                        btn.isEnabled = true
                    }
                    pwdNotEmpty = true
                }
            }
        })

        btn.setOnClickListener {
            listener.changePrefs(rlogin.text.toString(), rpwd.text.toString())
        }
    }
}
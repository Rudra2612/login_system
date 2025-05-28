package com.example.app7.controller

import android.content.Context

class PrefController(context: Context) {

    private val sp = context.getSharedPreferences("login",Context.MODE_PRIVATE)
    private val spEditor = sp.edit().apply {
        commit()
    }

    fun setUser(email: String) {
        spEditor.putString("user",email).apply()
    }

    fun isLogin(): Boolean {
        return sp.getString("user","")!!.isNotEmpty()
    }

    fun removeUser() {
        spEditor.putString("user", null).apply()
    }

}

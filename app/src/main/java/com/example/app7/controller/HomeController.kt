package com.example.app7.controller

import android.content.Context
import com.example.app7.model.DatabaseHelper

class HomeController(context: Context) {

    private val db = DatabaseHelper(context)
    fun adduser(email: String, password: String) {
        db.insertUser(email,password)
    }

}
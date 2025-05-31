package com.example.app7.controller

import android.content.Context
import androidx.compose.runtime.MutableState
import com.example.app7.model.DatabaseHelper
import com.example.app7.model.UserModel

class HomeController(context: Context) {

    private val db = DatabaseHelper(context)
    fun addUser(email: String, password: String) {
        db.insertUser(email,password)
    }

    fun isUserExist(email: String, password: String): Boolean {
        return  db.isUserExist(email,password)
    }

    fun getAllUser(): ArrayList<UserModel> {
        return db.getUser()
    }

    fun isUserExist1(email: String): Boolean {
        return db.isUserExist1(email)
    }

    fun removeUser(email: String) {
        db.removeUser(email)
    }

    fun getOldPassword(email: String): String {
        return db.getOldPassword(email)
    }

    fun setNewPassword(email: String, password: String) {
        db.setNewPassword(email,password)
    }

}
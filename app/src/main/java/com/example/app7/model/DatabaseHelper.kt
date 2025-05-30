package com.example.app7.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "MYSQL", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table users(id integer primary key autoincrement,email Text,password Text)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }

    fun insertUser(email: String, password: String) {
        val insert = "insert into users (email,password) values ('$email','$password')"
        writableDatabase.execSQL(insert)
    }

    fun isUserExist(email: String, password: String) : Boolean {
        val check = "select * from users where email='$email' and password='$password'"
        val cursor = readableDatabase.rawQuery(check,null)
        val isFound = cursor.moveToNext()
        cursor.close()
        return  isFound
    }

    fun getUser(): ArrayList<UserModel> {
        val select = "select * from users"
        val cursor = readableDatabase.rawQuery(select,null)
        val listOfUser = ArrayList<UserModel>()

        while (cursor.moveToNext()) {
            val id = cursor.getInt(0)
            val email = cursor.getString(1)
            val password = cursor.getString(2)
            val user = UserModel(id, email, password)
            listOfUser.add(user)
        }

        cursor.close()
        return listOfUser
    }

    fun isUserExist1(email: String): Boolean {
        val check  = "select email from users where email='$email'"
        val cursor = readableDatabase.rawQuery(check,null)
        val isFound = cursor.moveToNext()
        cursor.close()
        return isFound
    }

    fun removeUser(email: String) {
        val remove = "delete from users where email='$email'"
        readableDatabase.execSQL(remove)
    }

    fun getOldPassword(email: String): String {
        val getPassword = "select password from users where email='$email'"
        val cursor = readableDatabase.rawQuery(getPassword,null)
        var password = ""
        while (cursor.moveToNext()) {
            val passwordIndex = cursor.getColumnIndex("password")
            password = cursor.getString(passwordIndex)
        }
        cursor.close()
        return password
    }

    fun setNewPassword(email: String, password: String) {
        val update = "update users set password='$password' where email='$email'"
        writableDatabase.execSQL(update)
    }
}
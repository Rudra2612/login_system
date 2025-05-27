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
}
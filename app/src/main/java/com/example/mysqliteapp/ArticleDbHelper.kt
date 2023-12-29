package com.example.mysqliteapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ArticleDbHelper(context: Context):SQLiteOpenHelper(context,DBNAME,null,DBVERSION) {

    companion object{
        const val DBNAME="ArticleDataBase"
        const val DBVERSION=1
    }

    override fun onCreate(database: SQLiteDatabase?) {
        val sql = "CREATE TABLE ${DB.TABLE_NAME} (" +
                "${DB.ID} INTEGER PRIMARY KEY," +
                "${DB.TITLE} TEXT," +
                "${DB.BODY} TEXT" +
                ")"
        database?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
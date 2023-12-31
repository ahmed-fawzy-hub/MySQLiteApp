package com.example.mysqliteapp

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mysqliteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataBaseHelper: ArticleDbHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataBaseHelper= ArticleDbHelper(applicationContext)
        addListener()
    }
    private fun addListener(){
        binding.btnSave.setOnClickListener {
            val title=binding.inputTitle.text.toString()
            val body=binding.inputBody.text.toString()
            val newEntry=ContentValues().apply {
                put(DB.TITLE,title)
                put(DB.BODY,body)
            }
            dataBaseHelper.writableDatabase.insert(DB.TABLE_NAME,null,newEntry)
        }
        binding.btnLog.setOnClickListener {
            readData()
        }
    }

    private fun readData() {
        val cursor=dataBaseHelper.readableDatabase.rawQuery( "SELECT * FROM ${DB.TABLE_NAME}",
            arrayOf<String>()
        )
        while (cursor.moveToNext()){
            val id=cursor.getInt(0)
            val title=cursor.getString(1)
            val body=cursor.getString(2)
            Log.d("MAIN_ACTIVITY", "$id - $title - $body")
        }
    }
}
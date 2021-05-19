package com.example.datenight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dn_MA_continue: TextView =  findViewById(R.id.dn_MA_continue)

        dn_MA_continue.setOnClickListener{
            val intent = Intent(this, DecisionPageActivity::class.java)
            startActivity( intent )
        }
    }
}
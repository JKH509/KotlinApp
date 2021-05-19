package com.example.datenight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DecisionPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_decision_page)

        val selfDate : TextView =  findViewById(R.id.tv_self_selection)
        val couplesDate : TextView =  findViewById(R.id.tv_couples_selection)

        selfDate.setOnClickListener {
            val intent = Intent(this, SelfActivity::class.java)
            startActivity( intent )
        }

        couplesDate.setOnClickListener {
            val intent = Intent(this, CouplesActivity::class.java)
            startActivity( intent )
        }

    }
}
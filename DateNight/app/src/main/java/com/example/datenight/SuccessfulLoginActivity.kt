package com.example.datenight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_successful_login.*

class SuccessfulLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_successful_login)

        val userId = intent.getStringExtra("user_id")
        val emailId = intent.getStringExtra("email_id")

        tv_user_id.text = "User ID :: $userId"
        tv_email_id.text = "Email ID :: $emailId"

        log_out_button.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this@SuccessfulLoginActivity, MainActivity::class.java))
        }
    }
}
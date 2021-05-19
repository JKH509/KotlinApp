package com.example.datenight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_new_user_login.*

class NewUserLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_user_login)

        registerButton.setOnClickListener {
            when {
                TextUtils.isEmpty(et_new_user_email.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@NewUserLoginActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(et_new_user_password.text.toString().trim { it <= ' ' }) -> {
                    Toast.makeText(
                        this@NewUserLoginActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = et_new_user_email.text.toString().trim { it <= ' ' }
                    val password: String = et_new_user_password.text.toString().trim { it <= ' ' }

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {

                                val firebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@NewUserLoginActivity,
                                    "You are successfully registered",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                    Intent(
                                        this@NewUserLoginActivity,
                                        SuccessfulLoginActivity::class.java
                                    )
                                intent.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", firebaseUser.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@NewUserLoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }
    }
}
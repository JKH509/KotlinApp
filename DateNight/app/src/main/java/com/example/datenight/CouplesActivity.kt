package com.example.datenight

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_couples.*

class CouplesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_couples)

//        val email = findViewById<EditText>(R.id.et_login_email)
//        val password = findViewById<EditText>(R.id.et_login_password)

        login_button.setOnClickListener{
            when{
                TextUtils.isEmpty(et_login_email.text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@CouplesActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(et_login_password.text.toString().trim {it <= ' '}) -> {
                    Toast.makeText(
                        this@CouplesActivity,
                        "Please enter email",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = et_login_email.text.toString().trim {it <= ' '}
                    val password: String = et_login_password.text.toString().trim {it <= ' '}

                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(
                                    this@CouplesActivity,
                                    "You are successfully logged in",
                                    Toast.LENGTH_SHORT
                                ).show()

                                val intent =
                                    Intent(this@CouplesActivity, SuccessfulLoginActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                intent.putExtra("user_id", FirebaseAuth.getInstance().currentUser!!.uid)
                                intent.putExtra("email_id", email)
                                startActivity(intent)
                                finish()

                            } else {
                                Toast.makeText(
                                    this@CouplesActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                }
            }
        }

        val tv_new_account_page : TextView =  findViewById(R.id.tv_new_account_page)

        tv_new_account_page.setOnClickListener {
            val intent = Intent(this, NewUserLoginActivity::class.java)
            startActivity( intent )
        }
    }
}
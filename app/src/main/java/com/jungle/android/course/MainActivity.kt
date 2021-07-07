package com.jungle.android.course

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var signInBtn: Button
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInBtn = findViewById(R.id.btnSignIn)
        editTextEmail = findViewById(R.id.etEmail)
        scrollView = findViewById(R.id.scrollView)

        editTextEmail.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) scrollDown(450)
        }

        editTextEmail.setOnClickListener {
            scrollDown(250)
        }

        signInBtn.setOnClickListener {
            val email = editTextEmail.text.toString()
            if (email.isEmpty()) {
                editTextEmail.error = getString(R.string.enter_email)
            }

            if (email.isNotBlank()) {
                editTextEmail.error = null

                val intent = Intent(this, ListActivity::class.java)
                intent.putExtra(EMAIL_EXTRA, email)
                startActivity(intent)
            }
        }
    }

    private fun scrollDown(delayInMillis: Long) {
        scrollView.postDelayed({
            scrollView.fullScroll(View.FOCUS_DOWN)
        }, delayInMillis)
    }
}
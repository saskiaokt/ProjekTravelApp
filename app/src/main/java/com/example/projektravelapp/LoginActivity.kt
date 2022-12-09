package com.example.projektravelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    lateinit var btnSubmit : Button
    lateinit var etName : EditText
    lateinit var txtName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnSubmit = findViewById(R.id.button)
        etName = findViewById(R.id.editTextTextPersonName)
        etName = findViewById(R.id.editTextTextPassword)
        txtName = findViewById(R.id.textView3)
        txtName = findViewById(R.id.textView4)


        btnSubmit.setOnClickListener {
            txtName.text = etName.text
        }

    }
    }

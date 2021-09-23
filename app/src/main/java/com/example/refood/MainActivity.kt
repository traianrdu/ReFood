package com.example.refood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val btnLogIn = findViewById<Button>(R.id.log_in_button)
        btnLogIn.setOnClickListener {
            if (username.text.toString() == "testcustomer" && password.text.toString() == "testcustomer") {
                val intent = Intent(this, CustomerMain::class.java)
                startActivity(intent)
            } else if (username.text.toString() == "testcompany" && password.text.toString() == "testcompany") {
                val intent = Intent(this, CompanyMain::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
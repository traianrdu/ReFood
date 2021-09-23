package com.example.refood

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Traian Plosca on 23/09/2021.
 */
class CompanyMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_main)
        setTitle("Presco")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
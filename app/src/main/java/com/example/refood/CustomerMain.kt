package com.example.refood

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.LayoutInflater
import android.widget.ImageButton


/**
 * Created by Traian Plosca on 23/09/2021.
 */
class CustomerMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_main)
        setTitle("Gusztáv Hunor")

        // showing the back button in action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val rewards = findViewById<Button>(R.id.rewards)
        rewards.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen)

            val inflater: LayoutInflater =
                this.layoutInflater // receive the inflater to create the view

            val dialogView: View =
                inflater.inflate(R.layout.dialog_rewards, null) // create the view

            val closeDialogButton = dialogView.findViewById<ImageButton>(R.id.close_dialog_button)
            alertDialog.setView(dialogView) // set the view

            val dialog: AlertDialog = alertDialog.create()
            closeDialogButton.setOnClickListener { dialog.dismiss() }

            dialog.show()
        }
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
package com.example.refood

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.LayoutInflater
import android.widget.*
import android.widget.Toast

import androidx.core.app.ActivityCompat.startActivityForResult

import android.content.pm.PackageManager
import android.os.Build

import androidx.annotation.NonNull
import androidx.annotation.RequiresApi


/**
 * Created by Traian Plosca on 23/09/2021.
 */
class CustomerMain : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
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

        val settings = findViewById<ImageView>(R.id.settings)
        settings.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen)

            val inflater: LayoutInflater =
                this.layoutInflater // receive the inflater to create the view

            val dialogView: View =
                inflater.inflate(R.layout.dialog_rewards, null) // create the view

            val closeDialogButton = dialogView.findViewById<ImageButton>(R.id.close_dialog_button)
            val listView = dialogView.findViewById<ListView>(R.id.dialog_item_selection)
            val title = dialogView.findViewById<TextView>(R.id.selection_text_dialog)
            listView.visibility = View.GONE
            title.text = "Settings"

            alertDialog.setView(dialogView) // set the view

            val dialog: AlertDialog = alertDialog.create()
            closeDialogButton.setOnClickListener { dialog.dismiss() }

            dialog.show()
        }

        val scanBtn = findViewById<Button>(R.id.scan_btn)
        scanBtn.setOnClickListener {
            if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {
                requestPermissions(Array<String>(1){Manifest.permission.CAMERA}, 100)
            } else {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
            }
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show()
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivityForResult(cameraIntent, 1888)
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }
}
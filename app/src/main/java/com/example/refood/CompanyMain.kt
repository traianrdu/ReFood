package com.example.refood

import android.R.attr
import android.os.Bundle
import android.view.MenuItem
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.WriterException

import android.R.attr.bitmap
import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog


/**
 * Created by Traian Plosca on 23/09/2021.
 */
class CompanyMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.company_main)
        setTitle("Presco")

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val qrCodeIV = findViewById<ImageView>(R.id.qrcode)

        val width: Int = 800
        val dimen = width * 3/4

        val qrEncoder = QRGEncoder("refood", null, QRGContents.Type.TEXT, dimen)
        try {
            // getting our qrcode in the form of bitmap.
            val bitmap: Bitmap = qrEncoder.encodeAsBitmap()
            // the bitmap is set inside our image
            // view using .setimagebitmap method.
            qrCodeIV.setImageBitmap(bitmap)
        } catch (e: WriterException) {
            // this method is called for
            // exception handling.
            Log.e("Tag", e.toString())
        }

        val mapCompany = findViewById<ImageView>(R.id.map_company)
        mapCompany.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this, android.R.style.Theme_Light_NoTitleBar_Fullscreen)

            val inflater: LayoutInflater =
                this.layoutInflater // receive the inflater to create the view

            val dialogView: View =
                inflater.inflate(R.layout.dialog_rewards, null) // create the view

            val closeDialogButton = dialogView.findViewById<ImageButton>(R.id.close_dialog_button)
            val listView = dialogView.findViewById<ListView>(R.id.dialog_item_selection)
            val title = dialogView.findViewById<TextView>(R.id.selection_text_dialog)
            val mapdialog = dialogView.findViewById<ImageView>(R.id.map_dialog2)
            listView.visibility = View.GONE
            title.text = "Map"
            mapdialog.visibility= View.VISIBLE

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
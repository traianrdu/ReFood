package com.example.refood

import android.R.attr
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.WriterException

import android.R.attr.bitmap
import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView


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
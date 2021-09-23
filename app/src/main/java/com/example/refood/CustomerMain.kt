package com.example.refood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Traian Plosca on 23/09/2021.
 */
class CustomerMain : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.customer_main)
        setTitle("Customer")
    }
}
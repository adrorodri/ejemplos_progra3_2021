package com.adrorodri.ejemplosprogra32021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        println("onCreate DetailsActivity")

        val usernameRecibido = intent.getStringExtra("username")
        val passwordRecibido = intent.getStringExtra("password")

        val user = intent.getSerializableExtra("user") as Usuario

        textViewBienvenidos.text = "Bienvenido " + user.username
    }

    override fun onStart() {
        super.onStart()
        println("onStart DetailsActivity")
    }

    override fun onResume() {
        super.onResume()
        println("onResume DetailsActivity")
    }

    override fun onPause() {
        super.onPause()
        println("onPause DetailsActivity")
    }

    override fun onStop() {
        super.onStop()
        println("onStop DetailsActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy DetailsActivity")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart DetailsActivity")
    }
}
package com.adrorodri.ejemplosprogra32021

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_compartir_texto.*

class CompartirTextoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compartir_texto)

        val textoCompartido = intent.getStringExtra(Intent.EXTRA_TEXT)
        textView.text = textoCompartido
    }
}
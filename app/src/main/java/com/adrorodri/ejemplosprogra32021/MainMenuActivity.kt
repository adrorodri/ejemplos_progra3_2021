package com.adrorodri.ejemplosprogra32021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        println("onCreate DetailsActivity")

        val usernameRecibido = intent.getStringExtra("username")
        val passwordRecibido = intent.getStringExtra("password")

        val user = intent.getSerializableExtra("user") as Usuario

        textViewBienvenidos.text = "Bienvenido " + user.username

        val productoHamburguesa = Producto(R.drawable.hamburguesa_1, "Hamburguesa Simple", 15.0, "Hamburguesa de 200g con queso y huevo")
        val productoSalchipapa = Producto(R.drawable.salchipapa_1, "Salchipapa", 13.0, "Acompañada de aderezos")
        val productoLomito = Producto(R.drawable.sandwich_lomito_1, "Sandwich de Lomito", 16.0, "Acompañado de aderezos")

        menuHamburguesas.setOnClickListener {
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra("producto", Gson().toJson(productoHamburguesa))
            startActivity(intent)
        }
        menuLomitos.setOnClickListener {
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra("producto", Gson().toJson(productoLomito))
            startActivity(intent)
        }
        menuSalchipapas.setOnClickListener {
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra("producto", Gson().toJson(productoSalchipapa))
            startActivity(intent)
        }


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
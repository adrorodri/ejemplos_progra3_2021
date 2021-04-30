package com.adrorodri.ejemplosprogra32021

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

        val carritoDeCompras = Gson().fromJson(intent.getStringExtra("carrito"), CarritoDeCompras::class.java)

        carritoDeCompras.listaProductos[0].cantidad = 5

        buttonAceptar.setOnClickListener {
            val intent = Intent()
            intent.putExtra("carrito", Gson().toJson(carritoDeCompras))
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        val listaNombresProductos = mutableListOf<String>()
        carritoDeCompras.listaProductos.forEach { producto -> listaNombresProductos.add(producto.nombre + " - " + producto.cantidad) }

        listViewProductos.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaNombresProductos)
    }
}
package com.adrorodri.ejemplosprogra32021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        val producto = Gson().fromJson(intent.getStringExtra("producto"), Producto::class.java)

        textViewNombreProducto.text = producto.nombre
        imageViewProducto.setImageResource(producto.imagen)
        textViewPrecio.text = producto.precio.toString() + " $"
        textViewDescripcion.text = producto.descripcion
    }
}
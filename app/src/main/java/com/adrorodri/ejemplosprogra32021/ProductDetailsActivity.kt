package com.adrorodri.ejemplosprogra32021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        radioGroupOpcionesRefresco.check(R.id.radioButtonAgua)
        radioGroupOpcionesRefresco.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId) {
                R.id.radioButtonCocaCola -> {
                    Toast.makeText(
                        this,
                        "Selecciona una opcion mas saludable mejor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.radioButtonFanta -> {
                    Toast.makeText(
                        this,
                        "Selecciona una opcion mas saludable mejor",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.radioButtonAgua -> {
                    Toast.makeText(
                        this,
                        "Este esta mejor!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
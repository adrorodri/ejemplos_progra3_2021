package com.adrorodri.ejemplosprogra32021

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    val requestCodeCarrito = 123

    val productoHamburguesa = Producto(R.drawable.hamburguesa_1, "Hamburguesa Simple", 15.0, "Hamburguesa de 200g con queso y huevo")
    val productoSalchipapa = Producto(R.drawable.salchipapa_1, "Salchipapa", 13.0, "Acompañada de aderezos")
    val productoLomito = Producto(R.drawable.sandwich_lomito_1, "Sandwich de Lomito", 16.0, "Acompañado de aderezos")

    var carritoDeCompras = CarritoDeCompras(listOf(productoHamburguesa, productoSalchipapa, productoLomito))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        println("onCreate DetailsActivity")

        val usernameRecibido = intent.getStringExtra("username")
        val passwordRecibido = intent.getStringExtra("password")

        val user = intent.getSerializableExtra("user") as Usuario

        textViewBienvenidos.text = "Bienvenido " + user.username

        var cantidad = 0
        for(producto in carritoDeCompras.listaProductos){
            cantidad += producto.cantidad
        }
        textViewCantidad.text = cantidad.toString()

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
        imageViewShoppingCart.setOnClickListener {
            val intent = Intent(this, ShoppingCartActivity::class.java)
            intent.putExtra("carrito", Gson().toJson(carritoDeCompras))
            startActivityForResult(intent, requestCodeCarrito)
        }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId) {
                R.id.menuItemGoToShoppingCart -> {
                    val intent = Intent(this, ShoppingCartActivity::class.java)
                    intent.putExtra("carrito", Gson().toJson(carritoDeCompras))
                    startActivityForResult(intent, requestCodeCarrito)
                }
                R.id.menuItemGoToMyFavorites -> {
                    Toast.makeText(this, "Mis Favoritos", Toast.LENGTH_SHORT).show()
                }
                R.id.menuItemGoToAboutUs -> {
                    Toast.makeText(this, "Acerca de Nosotros", Toast.LENGTH_SHORT).show()
                }
            }
            true
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            carritoDeCompras = Gson().fromJson(data?.getStringExtra("carrito"), CarritoDeCompras::class.java)

            var cantidad = 0
            for(producto in carritoDeCompras.listaProductos){
                cantidad += producto.cantidad
            }
            textViewCantidad.text = cantidad.toString()
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(this, "Carrito de compras cancelado", Toast.LENGTH_SHORT).show()
        }
    }
}
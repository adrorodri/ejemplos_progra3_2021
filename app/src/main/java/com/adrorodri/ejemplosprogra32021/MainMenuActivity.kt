package com.adrorodri.ejemplosprogra32021

import android.app.Activity
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    val requestCodeCarrito = 123

    var carritoDeCompras = CarritoDeCompras(listOf())

    val adapter = ProductListRecyclerViewAdapter(TemporalStorage.listaProductos)

    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        println("onCreate DetailsActivity")

        val usernameRecibido = intent.getStringExtra("username")
        val passwordRecibido = intent.getStringExtra("password")

//        val user = intent.getSerializableExtra("user") as Usuario
        val user = TemporalStorage.usuario!!

        textViewBienvenidos.text = "Bienvenido " + user.username
        imageViewUsuario.setImageURI(user.imageUri!!)

        var cantidad = 0
        for(producto in carritoDeCompras.listaProductos){
            cantidad += producto.cantidad
        }
        textViewCantidad.text = cantidad.toString()

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
                R.id.menuItemImageCapture -> {
                    val intent = Intent(this, AddProductActivity::class.java)
                    startActivity(intent)
                }
                R.id.menuItemSignOut -> {
                    sharedPreferencesManager.borrarUsuarioInicioSesion(this)
                    finish()
                }
            }
            true
        }

        adapter.setOnProductItemClickListener { product ->
            val intent = Intent(this, ProductDetailsActivity::class.java)
            intent.putExtra("producto", Gson().toJson(product))
            startActivity(intent)
        }
        recyclerViewProductos.adapter = adapter
        recyclerViewProductos.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        buttonAddProduct.setOnClickListener {
            val intent = Intent(this, AddProductActivity::class.java)
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

        adapter.notifyDataSetChanged()
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
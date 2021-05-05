package com.adrorodri.ejemplosprogra32021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_new_user.*

class RegisterNewUserActivity : AppCompatActivity() {

    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_new_user)

        buttonCrearUsuario.setOnClickListener {
            val usuarioAGuardar = Usuario(editTextUsername.text.toString(), editTextPassword.text.toString())
            sharedPreferencesManager.crearUsuarioNuevo(this, usuarioAGuardar)
            finish()
        }
    }
}
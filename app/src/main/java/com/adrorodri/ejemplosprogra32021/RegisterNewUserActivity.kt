package com.adrorodri.ejemplosprogra32021

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_register_new_user.*

class RegisterNewUserActivity : AppCompatActivity() {

    val requestCodeGallery = 12345
    val sharedPreferencesManager = SharedPreferencesManager()
    var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_new_user)

        buttonCrearUsuario.setOnClickListener {
            val usuarioAGuardar = Usuario(editTextUsername.text.toString(), editTextPassword.text.toString(), imageUri)
            sharedPreferencesManager.crearUsuarioNuevo(this, usuarioAGuardar)
            finish()
        }

        buttonSelectImage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            startActivityForResult(Intent.createChooser(intent, "Selecciona una imagen!"), requestCodeGallery)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == requestCodeGallery) {
            if(resultCode == Activity.RESULT_OK) {
                imageUri = data?.data
                imageViewUsuario.setImageURI(imageUri)
            }
        }
    }
}
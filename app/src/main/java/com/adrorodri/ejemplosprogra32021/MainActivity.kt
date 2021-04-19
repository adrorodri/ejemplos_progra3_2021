package com.adrorodri.ejemplosprogra32021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val validUsersList = listOf(
            Usuario("Perrito", "12345"),
            Usuario("Gatito", "password"),
            Usuario("Lorito", "qwerty")
        )

        buttonSignIn.text = "DESDE EL CODIGO!"
        buttonSignIn.setOnClickListener {
            if(checkBoxRememberMe.isChecked) {
                textViewForgotPassword.text = "CLICK EN BOTON! > REMEMBER ME ON"
            } else {
                textViewForgotPassword.text = "CLICK EN BOTON! > REMEMBER ME OFF"
            }

            val username = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            for(user in validUsersList) {
                if(user.username == username && user.password == password) {
                    textViewForgotPassword.text = "LOGIN CORRECTO!"
                    break
                } else {
                    textViewForgotPassword.text = "LOGIN INCORRECTO!"
                }
            }

            progressBar.visibility = View.VISIBLE
        }

        checkBoxRememberMe.setOnCheckedChangeListener { buttonView, isChecked ->
            if(checkBoxRememberMe.isChecked) {
                textViewForgotPassword.text = "CHECKBOX CHANGED! > REMEMBER ME ON"
            } else {
                textViewForgotPassword.text = "CHECKBOX CHANGED! > REMEMBER ME OFF"
            }
        }

        editTextTextEmailAddress.doAfterTextChanged { textoNuevo ->
            textViewForgotPassword.text = "INPUT CHANGED! > " + textoNuevo
        }
    }
}

data class Usuario(val username: String, val password: String)
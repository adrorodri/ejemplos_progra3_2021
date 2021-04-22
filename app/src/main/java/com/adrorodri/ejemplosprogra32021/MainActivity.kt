package com.adrorodri.ejemplosprogra32021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("onCreate MainActivity")

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
                    val intent = Intent(this, DetailsActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    intent.putExtra("user", user)
                    startActivity(intent)
                    break
                } else {
                    Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_LONG).show()
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

    override fun onStart() {
        super.onStart()
        println("onStart MainActivity")
    }

    override fun onResume() {
        super.onResume()
        println("onResume MainActivity")
    }

    override fun onPause() {
        super.onPause()
        println("onPause MainActivity")
    }

    override fun onStop() {
        super.onStop()
        println("onStop MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy MainActivity")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart MainActivity")
    }
}
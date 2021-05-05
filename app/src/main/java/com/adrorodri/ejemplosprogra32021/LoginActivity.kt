package com.adrorodri.ejemplosprogra32021

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        println("onCreate MainActivity")

//        val validUsersList = listOf(
//            Usuario("Perrito", "12345"),
//            Usuario("Gatito", "password"),
//            Usuario("Lorito", "qwerty")
//        )

        val citiesList = listOf("LP", "OR", "PT", "CB", "SU", "TA", "PA", "BE", "SC")
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, citiesList)

        buttonSignIn.text = resources.getString(R.string.login)
        buttonSignIn.setOnClickListener {
            if (checkBoxRememberMe.isChecked) {
                textViewForgotPassword.text = "CLICK EN BOTON! > REMEMBER ME ON"
            } else {
                textViewForgotPassword.text = "CLICK EN BOTON! > REMEMBER ME OFF"
            }

            val username = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

//            for (user in validUsersList) {
//                if (user.username == username && user.password == password) {
//                    val intent = Intent(this, MainMenuActivity::class.java)
//                    intent.putExtra("username", username)
//                    intent.putExtra("password", password)
//                    intent.putExtra("user", user)
//                    startActivity(intent)
//                    break
//                } else {
//                    Toast.makeText(this, "Login Incorrecto!", Toast.LENGTH_LONG).show()
//                }
//            }

            val validUser = sharedPreferencesManager.obtenerUsuario(this)
            if(validUser != null) {
                if(validUser.username == username && validUser.password == password) {
                    val intent = Intent(this, MainMenuActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    intent.putExtra("user", validUser)
                    startActivity(intent)
                }
            }

            progressBar.visibility = View.VISIBLE
        }

        checkBoxRememberMe.setOnCheckedChangeListener { buttonView, isChecked ->
            if (checkBoxRememberMe.isChecked) {
                textViewForgotPassword.text = "CHECKBOX CHANGED! > REMEMBER ME ON"
            } else {
                textViewForgotPassword.text = "CHECKBOX CHANGED! > REMEMBER ME OFF"
            }
        }

        editTextTextEmailAddress.doAfterTextChanged { textoNuevo ->
            textViewForgotPassword.text = "INPUT CHANGED! > " + textoNuevo
        }

        textViewRegistrar.setOnClickListener {
            val intent = Intent(this, RegisterNewUserActivity::class.java)
            startActivity(intent)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            progressBarHorizontal.progress = 30
        }, 3000)

        Handler(Looper.getMainLooper()).postDelayed({
            progressBarHorizontal.progress = 80
        }, 5000)

        Handler(Looper.getMainLooper()).postDelayed({
            progressBarHorizontal.progress = 100
        }, 7000)
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
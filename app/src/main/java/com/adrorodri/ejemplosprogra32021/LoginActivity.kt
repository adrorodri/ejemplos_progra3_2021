package com.adrorodri.ejemplosprogra32021

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import kotlinx.android.synthetic.main.activity_login.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


class LoginActivity : AppCompatActivity() {

    val sharedPreferencesManager = SharedPreferencesManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        println("onCreate MainActivity")

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

            val validUsers = sharedPreferencesManager.obtenerUsuarios(this)
            for (validUser in validUsers) {
                if(validUser.username == username && validUser.password == password) {
                    TemporalStorage.usuario = validUser
                    val intent = Intent(this, MainMenuActivity::class.java)
                    intent.putExtra("username", username)
                    intent.putExtra("password", password)
                    startActivity(intent)
                }
            }

            progressBar.visibility = View.VISIBLE
        }

        requestPermissions()

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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults, this
        )
    }

    @AfterPermissionGranted(requestCodePermissions)
    private fun requestPermissions() {
        if (EasyPermissions.hasPermissions(this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {
            // Already have permission, do the thing
            // ...
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(
                this,
                "Se requieren permisos para usar la aplicacion",
                requestCodePermissions,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    companion object {
        const val requestCodePermissions = 1234
    }
}
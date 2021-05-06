package com.adrorodri.ejemplosprogra32021

import android.net.Uri
import com.google.gson.annotations.Expose
import java.io.Serializable

data class Usuario(
    @Expose val username: String,
    @Expose val password: String,
    @Expose val imageUri: Uri?
) : Serializable
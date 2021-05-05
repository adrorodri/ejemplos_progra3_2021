package com.adrorodri.ejemplosprogra32021

import com.google.gson.annotations.Expose
import java.io.Serializable

data class Usuario(@Expose val username: String, @Expose val password: String): Serializable
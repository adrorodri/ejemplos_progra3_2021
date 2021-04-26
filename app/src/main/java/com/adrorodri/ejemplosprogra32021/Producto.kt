package com.adrorodri.ejemplosprogra32021

import com.google.gson.annotations.Expose

data class Producto(
    @Expose val imagen: Int,
    @Expose val nombre: String,
    @Expose val precio: Double,
    @Expose val descripcion: String,
    @Expose var cantidad: Int = 1
)
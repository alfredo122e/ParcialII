package com.example.parcialii

data class Product(
    val nombreProducto : String = "",
    val cantidad : String = "",
    val nombreCliente : String = ""
){
    override fun toString() = nombreProducto + "\t" + cantidad + "\t" + nombreCliente

}

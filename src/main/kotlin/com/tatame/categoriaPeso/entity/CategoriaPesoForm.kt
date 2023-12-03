package com.tatame.categoriaPeso.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class CategoriaPesoForm(

    var id: Int,

    val nome: String,

    val pesoMinimo: Double,

    val pesoMaximo: Double
)

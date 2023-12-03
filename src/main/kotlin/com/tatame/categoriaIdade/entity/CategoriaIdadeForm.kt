package com.tatame.categoriaIdade.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class CategoriaIdadeForm(

    val idCategoria: Int?,

    val nome: String,

    val idadeMinima: Double,

    val idadeMaxima: Double
)

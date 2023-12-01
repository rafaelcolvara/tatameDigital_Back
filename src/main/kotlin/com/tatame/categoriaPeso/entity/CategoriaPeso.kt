package com.tatame.categoriaPeso.entity

import jakarta.persistence.Column
import jakarta.persistence.Id

data class CategoriaPeso(

    @Id
    val id: Int,

    @Column(name = "nome")
    val nome: String
)

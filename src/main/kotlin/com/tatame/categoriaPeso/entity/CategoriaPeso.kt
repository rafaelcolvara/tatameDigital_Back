package com.tatame.categoriaPeso.entity

import jakarta.persistence.*

@Entity
@Table(name = "categoria_peso")
data class CategoriaPeso(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "nome")
    val nome: String
)

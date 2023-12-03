package com.tatame.categoriaPeso.entity

import jakarta.persistence.*

@Entity
@Table(name = "categoria_peso")
data class CategoriaPesoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "nome")
    val nome: String,

    @Column(name = "pesoMinimo")
    val pesoMinimo: Double,

    @Column(name = "pesoMaximo")
    val pesoMaximo: Double

)

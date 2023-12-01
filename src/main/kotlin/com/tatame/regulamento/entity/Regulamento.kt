package com.tatame.regulamento.entity

import jakarta.persistence.*

@Entity
@Table(name = "Regulamento")
data class Regulamento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "nome")
    val nome: String
)

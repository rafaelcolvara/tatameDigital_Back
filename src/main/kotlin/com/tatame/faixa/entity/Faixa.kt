package com.tatame.faixa.entity

import jakarta.persistence.*

@Entity
@Table(name = "Faixa")
class Faixa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val cor: String
)


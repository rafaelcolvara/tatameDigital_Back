package com.arena.endereco.entity

import jakarta.persistence.*

@Entity
@Table(name = "Cidade")
data class Cidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0,

    @Column(name = "nome", nullable = false)
    var nome: String
)

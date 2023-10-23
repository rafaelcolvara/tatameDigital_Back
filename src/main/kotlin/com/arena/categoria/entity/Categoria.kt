package com.arena.categoria.entity

import jakarta.persistence.*

@Entity
@Table(name = "Categoria")
data class Categoria(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Int? = null,

    @Column(name = "nome", nullable = false)
    val nome: String?
)

package com.tatame.pessoas.professor.entity

import jakarta.persistence.*

@Entity
@Table(name = "Professor")
data class Professor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Long ? = null,

    @Column(name = "nome", nullable = false)
    val nome: String,

    @Column(name = "email", nullable = false)
    val email: String,

    @Column(name = "celular", nullable = false)
    val celular: String,


)

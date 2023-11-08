package com.arena.pessoas.usuario.entity

import jakarta.persistence.*


@Entity
@Table(name = "Usuario")
data class Usuario(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "nome", nullable = false)
    val nome: String,

    // Assuming that email should be a text field instead of smallint
    @Column(name = "email", nullable = false)
    val email: String,

    // Assuming that Senha (password) should be a text field instead of smallint
    @Column(name = "Senha", nullable = false)
    val senha: String,

    @Column(name = "TipoPessoa", nullable = false)
    val tipoPessoa: String
)

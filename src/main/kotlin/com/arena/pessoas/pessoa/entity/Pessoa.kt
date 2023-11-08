package com.arena.pessoas.pessoa.entity

import jakarta.persistence.*
import java.math.BigInteger
import java.util.Date

@Entity
@Table(name = "Pessoa")
data class Pessoa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    var id: Int? = null,

    @Column(name = "nome", nullable = false)
    val nome: String,

    @Column(name = "celular", nullable = false)
    val celular: String,

    @Column(name = "dtNascimento", nullable = false)
    val dtNascimento: Date,

    @Column(name = "cpf", nullable = false)
    val cpf: BigInteger

)

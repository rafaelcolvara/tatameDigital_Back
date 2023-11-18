package com.tatame.pessoas.tipoPessoa.entity


import jakarta.persistence.*


@Entity
@Table(name = "TipoPessoa")
data class TipoPessoa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    val id: Int,

    @Column(nullable = false)
    val descricao: String
)
package com.tatame.regulamento.entity

import jakarta.persistence.*

@Entity
@Table(name = "Regulamento")
data class RegulamentoEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "sigla", length = 6)
    val sigla: String,

    @Column(name = "nome")
    val nome: String
)

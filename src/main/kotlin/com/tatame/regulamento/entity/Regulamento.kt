package com.tatame.regulamento.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Regulamento")
data class Regulamento(

    @Id
    val id: Int,

    @Column(name = "nome")
    val nome: String
)

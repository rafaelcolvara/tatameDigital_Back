package com.arena.contratante.entity

import jakarta.persistence.*

@Entity
@Table(name = "Contratante")
data class Contratante(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    val id : Int,

    @Column(name = "Nome", nullable = false)
    val nome: String,

    @Column(name = "Celular", nullable = false)
    val celular: String,

)

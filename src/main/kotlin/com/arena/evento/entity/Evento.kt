package com.arena.evento.entity

import jakarta.persistence.*
import java.time.LocalDate
@Entity
@Table(name = "Evento")
data class Evento(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Int? = null,

    @Column(name = "nome", nullable = false)
    val nome: String,

    @Column(name = "dtEvento", nullable = false)
    val dtEvento: LocalDate
)
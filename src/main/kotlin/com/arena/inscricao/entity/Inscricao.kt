package com.arena.inscricao.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Inscricao")
data class Inscricao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Int? = null,

    @Column(name = "pago", nullable = false)
    val pago: Boolean,

    @Column(name = "dtInscricao", nullable = false)
    val dtIncricao: LocalDateTime?,

    @Column(name = "idEvento", nullable = false)
    val id_Evento: Int?,

    @Column(name = "idCategoria", nullable= false)
    val id_Categoria: Int?,

    @Column(name = "idCompetidor", nullable = false)
    val id_Competidor: Int?
)

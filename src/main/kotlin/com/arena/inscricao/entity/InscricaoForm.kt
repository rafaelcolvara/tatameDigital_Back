package com.arena.inscricao.entity

import jakarta.persistence.Column
import java.time.LocalDateTime


data class InscricaoForm (

    val id: Int? = null,

    val pago: Boolean,

    val dtIncricao: LocalDateTime?,

    val id_Evento: Int?,

    val id_Categoria: Int?,

    val id_Competidor: Int?
)
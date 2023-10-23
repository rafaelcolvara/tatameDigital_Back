package com.arena.inscricao.entity

import java.time.LocalDateTime

data class Inscricao(
    val id: Int,
    val pago: Boolean,
    val dtIncricao: LocalDateTime?,
    val id_Evento: Int?,
    val id_Categoria: Int?,
    val id_Competidor: Int?
)

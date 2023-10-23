package com.arena.evento.entity

import java.time.LocalDate

data class Evento(
    val id: Int,
    val nome: String,
    val dtEvento: LocalDate
)
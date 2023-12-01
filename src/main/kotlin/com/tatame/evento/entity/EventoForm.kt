package com.tatame.evento.entity

import com.tatame.regulamento.entity.Regulamento
import java.time.LocalDate

data class EventoForm(
    val nome: String,
    val dtEvento: LocalDate,
    val fotoEvento: String,
    val regulamento: Regulamento,
)

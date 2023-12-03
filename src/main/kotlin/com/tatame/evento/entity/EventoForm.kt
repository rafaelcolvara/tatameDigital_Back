package com.tatame.evento.entity

import com.tatame.regulamento.entity.RegulamentoEntity
import java.time.LocalDate

data class EventoForm(
    val nome: String,
    val dtEvento: LocalDate,
    val fotoEvento: String,
    val regulamentoEntity: RegulamentoEntity,
)

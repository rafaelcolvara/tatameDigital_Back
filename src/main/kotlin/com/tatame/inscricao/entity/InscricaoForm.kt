package com.tatame.inscricao.entity

import java.time.LocalDateTime


data class InscricaoForm (

    val pago: Boolean,

    val dtIncricao: LocalDateTime?,

    val id_Evento: Int?,

    val id_Competidor: Int?,

    val id_Regulamento_Categoria: Int?,
)
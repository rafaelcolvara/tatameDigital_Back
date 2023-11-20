package com.tatame.inscricao.entity


import com.tatame.pessoas.competidor.entity.CompetidorDTO
import java.time.LocalDate
import java.time.LocalDateTime

data class IncricaoDTO(

    val pago: Boolean,

    val dtIncricao: LocalDateTime?,

    val nomeEvento: String,

    val dataEvento: LocalDate,

    val categoriaPeso: String,

    val faixa: String,

    val competidor: CompetidorDTO,

    )

package com.tatame.pessoas.competidor.entity

import com.tatame.categoria.interfaces.TipoCampeonato


data class CompetidorDTO(

    val nomeCompetidor:String,

    val academia: String,

    val categoriaIdade: TipoCampeonato,

    )

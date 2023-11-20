package com.tatame.pessoas.competidor.entity

import com.tatame.pessoas.pessoa.EnumCategoriaIdade


data class CompetidorDTO(

    val nomeCompetidor:String,

    val academia: String,

    val categoriaIdade: EnumCategoriaIdade,

    )

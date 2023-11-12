package com.tatame.pessoas.competidor.entity


import com.tatame.academia.entity.Academia
import com.tatame.faixa.entity.Faixa
import com.tatame.pessoas.pessoa.entity.Pessoa

data class CompetidorForm(

    val academia: Academia,
    val faixa: Faixa,
    val pessoa: Pessoa

)

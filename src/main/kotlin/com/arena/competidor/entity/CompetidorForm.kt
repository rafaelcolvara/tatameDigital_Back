package com.arena.competidor.entity

import com.arena.endereco.entity.EnderecoForm
import java.util.Date

data class CompetidorForm(
    val nome: String,
    val dtNascimento: Date,
    val idAcademia: Int?,
    val idFaixa: Int?,
    val endereco: EnderecoForm
)

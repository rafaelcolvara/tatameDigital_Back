package com.arena.competidor.entity

import com.arena.endereco.entity.EnderecoForm

data class CompetidorForm(
    val nome: String,
    val dtNascimento: java.time.LocalDate,
    val idAcademia: Int?,
    val idFaixa: Int?,
    val endereco: EnderecoForm
)

package com.tatame.pessoas.competidor.entity


import com.tatame.endereco.entity.EnderecoForm
import java.math.BigInteger
import java.time.LocalDate
import java.util.Date

data class CompetidorForm(

    val idAcademia: Int,
    val idFaixa: Int,
    val nomeCompetidor: String,
    val dataNascimento: LocalDate,
    val celular: Int,
    val dddCelular: Int,
    val cnpjcpj: BigInteger,
    val foto: String,
    val endereco: EnderecoForm

)

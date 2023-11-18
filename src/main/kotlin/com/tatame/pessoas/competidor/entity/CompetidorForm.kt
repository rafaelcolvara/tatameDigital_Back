package com.tatame.pessoas.competidor.entity


import com.tatame.endereco.entity.EnderecoForm
import java.math.BigInteger
import java.util.Date

data class CompetidorForm(

    val idAcademia: Int,
    val idFaixa: Int,
    val nomeCompetidor: String,
    val dataNascimento: Date,
    val celular: Int,
    val dddCelular: Int,
    val cnpjcpj: BigInteger,
    val foto: String,
    val endereco: EnderecoForm

)

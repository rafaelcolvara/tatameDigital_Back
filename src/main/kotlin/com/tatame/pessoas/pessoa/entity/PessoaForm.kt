package com.tatame.pessoas.pessoa.entity

import com.tatame.endereco.entity.Endereco
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigInteger
import java.util.*

data class PessoaForm(

    val id: Int,
    val nome: String,
    val dataNascimento: Date,
    val celular: String,
    val cpfCnpj: BigInteger,
    val foto: String?,
    val endereco: Endereco?
)

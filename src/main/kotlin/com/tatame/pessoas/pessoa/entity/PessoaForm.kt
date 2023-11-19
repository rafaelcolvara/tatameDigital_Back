package com.tatame.pessoas.pessoa.entity

import com.tatame.endereco.entity.Endereco
import com.tatame.endereco.entity.EnderecoForm
import jakarta.persistence.Column
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.math.BigInteger
import java.util.*

data class PessoaForm(

    val idPessoa: Int,
    val nome: String?,
    val dataNascimento: Date?,
    val celular: Int?,
    val dddCelular: Int?,
    val cpfCnpj: BigInteger?,
    val foto: String?,
    val endereco: EnderecoForm?
)

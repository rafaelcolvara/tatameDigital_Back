package com.arena.pessoas.pessoa.entity

import com.arena.pessoas.papelPessoa.entity.PapelPessoaId
import jakarta.persistence.*
import java.math.BigInteger
import java.util.Date

@Entity
@Table(name = "PapelPessoa")
data class PapelPessoa(

    @EmbeddedId
    var id: PapelPessoaId,

    @Column(name = "dtInicio", nullable = false)
    val dtInicio: Date,

    @Column(name = "dtFim", nullable = false)
    val dtFim: Date

)

package com.tatame.pessoas.papelPessoa.entity


import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.tipoPessoa.entity.TipoPessoa
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "PapelPessoa")
data class PapelPessoa(

    @EmbeddedId
    var id: PapelPessoaId,

    @Column(name = "dtInicio", nullable = false)
    val dtInicio: Date,

    @Column(name = "dtFim", nullable = false)
    val dtFim: Date,

    @ManyToOne
    @JoinColumn(name = "id_tipo_pessoa")
    val tipoPessoa: TipoPessoa,

    @ManyToOne
    @JoinColumn(name = "id_Pessoa")
    val pessoa: Pessoa
)

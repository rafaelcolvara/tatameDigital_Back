package com.arena.pessoas.papelPessoa.entity

import com.arena.usuario.entity.TipoPessoa
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
class PapelPessoaId(
    @Column(name = "id_tipopessoa")
    var idTipoPessoa:  Int,

    @Column(name = "id_pessoa")
    var idPessoa: Int
) : Serializable {
    // Implementações de equals e hashCode são necessárias para a chave composta
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as PapelPessoaId

        if (idTipoPessoa != other.idTipoPessoa) return false
        if (idPessoa != other.idPessoa) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idPessoa.hashCode()
        result = 31 * result + idTipoPessoa.hashCode()
        return result
    }
}

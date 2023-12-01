package com.tatame.regulamento.entity

import com.tatame.categoriaIdade.entity.CategoriaIdade
import com.tatame.categoriaPeso.entity.CategoriaPeso
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class RegulamentoCategoriaPK(

    val regulamento: Regulamento,
    val categoriaIdade: CategoriaIdade,
    val categoriaPeso: CategoriaPeso

): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegulamentoCategoriaPK

        if (regulamento != other.regulamento) return false
        if (categoriaIdade != other.categoriaIdade) return false
        return categoriaPeso == other.categoriaPeso
    }

    override fun hashCode(): Int {
        var result = regulamento.hashCode()
        result = 31 * result + categoriaIdade.hashCode()
        result = 31 * result + categoriaPeso.hashCode()
        return result
    }
}

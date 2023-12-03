package com.tatame.regulamento.entity

import com.tatame.categoriaIdade.entity.CategoriaIdadeEntity
import com.tatame.categoriaPeso.entity.CategoriaPeso
import jakarta.persistence.Embeddable
import java.io.Serializable

@Embeddable
data class RegulamentoCategoriaPK(

    val regulamento: Regulamento,
    val categoriaIdadeEntity: CategoriaIdadeEntity,
    val categoriaPeso: CategoriaPeso

): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RegulamentoCategoriaPK

        if (regulamento != other.regulamento) return false
        if (categoriaIdadeEntity != other.categoriaIdadeEntity) return false
        return categoriaPeso == other.categoriaPeso
    }

    override fun hashCode(): Int {
        var result = regulamento.hashCode()
        result = 31 * result + categoriaIdadeEntity.hashCode()
        result = 31 * result + categoriaPeso.hashCode()
        return result
    }
}

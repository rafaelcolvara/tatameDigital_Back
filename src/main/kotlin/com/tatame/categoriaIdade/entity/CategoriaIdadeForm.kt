package com.tatame.categoriaIdade.entity

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

data class CategoriaIdadeForm(

    var idCategoria: Int?,

    val nome: String,

    val idadeMinima: Double,

    val idadeMaxima: Double
)
{
    fun toEntity(): CategoriaIdadeEntity{
        return CategoriaIdadeEntity(id = this.idCategoria,
            nome = this.nome,
            idadeMinima = this.idadeMinima,
            idadeMaxima = this.idadeMaxima)
    }
}

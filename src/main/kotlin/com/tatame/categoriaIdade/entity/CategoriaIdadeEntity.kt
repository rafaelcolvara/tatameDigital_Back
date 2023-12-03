package com.tatame.categoriaIdade.entity

import jakarta.persistence.*

@Entity
@Table(name="categoria_idade")
data class CategoriaIdadeEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "Nome")
    val nome: String,

    @Column(name = "IdadeMinima")
    val idadeMinima: Int,

    @Column(name = "IdadeMaxima")
    val idadeMaxima: Int

)
{
    fun toForm(): CategoriaIdadeForm{
        return CategoriaIdadeForm(idCategoria = this.id,
            idadeMinima = this.idadeMinima,
            idadeMaxima = this.idadeMaxima,
            nome = this.nome)
    }
}
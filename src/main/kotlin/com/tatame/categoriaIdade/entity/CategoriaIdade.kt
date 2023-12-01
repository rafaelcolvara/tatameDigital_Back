package com.tatame.categoriaIdade.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name="CategoriaIdade")
data class CategoriaIdade(

    @Id
    val id: Int,

    @Column(name = "Nome")
    val nome: String,

    @Column(name = "IdadeMinima")
    val idadeMinima: Int,

    @Column(name = "IdadeMaxima")
    val idadeMaxima: Int

)

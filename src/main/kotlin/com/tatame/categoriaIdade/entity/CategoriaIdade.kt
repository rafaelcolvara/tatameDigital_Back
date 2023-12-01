package com.tatame.categoriaIdade.entity

import jakarta.persistence.*

@Entity
@Table(name="categoria_idade")
data class CategoriaIdade(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(name = "Nome")
    val nome: String,

    @Column(name = "IdadeMinima")
    val idadeMinima: Int,

    @Column(name = "IdadeMaxima")
    val idadeMaxima: Int

)

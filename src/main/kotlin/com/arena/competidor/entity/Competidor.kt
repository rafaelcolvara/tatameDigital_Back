package com.arena.competidor.entity

import com.arena.endereco.entity.Endereco
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name = "Competidor")
data class Competidor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Long ? = null,

    @Column(name = "nome", nullable = false)
    val nome: String,

    @Column(name = "dtNascimento", nullable = false)
    val dtNascimento: Date,

    @Column(name = "id_Academia")
    val idAcademia: Int? = null,

    @Column(name = "id_Faixa")
    val idFaixa: Int? = null,

    @Column(name = "endereco_id")
    val enderecoId: Long

)

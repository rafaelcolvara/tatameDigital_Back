package com.arena.competidor.entity

import jakarta.persistence.*


@Entity
@Table(name = "Competidor")
data class Competidor(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Long,

    @Column(name = "nome", nullable = false)
    val nome: String,

    @Column(name = "dtNascimento", nullable = false)
    val dtNascimento: java.time.LocalDate,

    @Column(name = "id_Academia")
    val idAcademia: Int?,

    @Column(name = "id_Faixa")
    val idFaixa: Int?,

    @Column(name = "id_Endereco")
    val idEndereco: Int?

)

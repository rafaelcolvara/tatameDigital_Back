package com.arena.endereco.entity

import com.arena.competidor.entity.Competidor
import jakarta.persistence.*

@Entity
@Table(name = "Endereco")
data class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "rua", nullable = false, length = 100)
    var rua: String,

    @Column(name = "complemento", length = 50)
    var complemento: String? = null,

    @Column(name = "numero")
    var numero: Int? = null,

    @Column(name = "cep", length = 9)
    var cep: String? = null,

    @Column(name = "id_cidade")
    val cidade: Long
)

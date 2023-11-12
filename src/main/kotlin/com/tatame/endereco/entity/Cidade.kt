package com.tatame.endereco.entity

import jakarta.persistence.*

@Entity
@Table(name = "Cidade")
data class Cidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "nome", nullable = false)
    var nome: String,

    @OneToMany(mappedBy = "cidade")
    var enderecos: List<Endereco> = mutableListOf()

)

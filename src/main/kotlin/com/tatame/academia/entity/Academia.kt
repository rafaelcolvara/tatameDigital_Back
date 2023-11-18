package com.tatame.academia.entity


import com.tatame.pessoas.pessoa.entity.Pessoa
import jakarta.persistence.*

@Entity
@Table(name = "Academia")
class Academia(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(nullable = false)
    val nome: String,

    @OneToOne
    @JoinColumn(name = "id_Professor")
    val professor: Pessoa?
)
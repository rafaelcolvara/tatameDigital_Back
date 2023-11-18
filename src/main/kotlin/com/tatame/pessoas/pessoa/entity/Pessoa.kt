package com.tatame.pessoas.pessoa.entity


import com.tatame.endereco.entity.Endereco
import jakarta.persistence.*
import java.math.BigInteger
import java.util.*


@Entity
@Table(name = "Pessoa")
class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(nullable = false)
    val nome: String,

    @Column(name = "dtNascimento", nullable = false)
    val dataNascimento: Date?,

    @Column(nullable = false)
    val celular: String,

    @Column(nullable = false)
    val cpfCnpj: BigInteger?,

    @Column(name = "foto")
    val foto: String?,

    @ManyToOne
    @JoinColumn(name = "id_Endereco")
    val endereco: Endereco?
)

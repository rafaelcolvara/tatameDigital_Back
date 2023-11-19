package com.tatame.pessoas.pessoa.entity

import com.tatame.endereco.entity.Endereco
import jakarta.persistence.*
import org.hibernate.annotations.DynamicUpdate
import java.math.BigInteger
import java.util.*

@Entity
@Table(name = "Pessoa")
@DynamicUpdate
class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(nullable = false)
    var nome: String,

    @Column(name = "dtNascimento", nullable = false)
    var dataNascimento: Date?,

    @Column(name = "dddCelular", nullable = false)
    var dddCelular: Int,

    @Column(name = "celular", nullable = false)
    var celular: Int,

    @Column(name = "cpfcnpj", nullable = false)
    var cpfCnpj: BigInteger?,

    @Column(name = "foto")
    var foto: String?,

    @ManyToOne
    @JoinColumn(name = "id_Endereco")
    var endereco: Endereco?
)

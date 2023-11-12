package com.tatame.pessoas.usuario.entity

import com.tatame.pessoas.pessoa.entity.Pessoa
import jakarta.persistence.*

@Entity
@Table(name = "Usuario")
class Usuario(
    @Id
    @Column(name = "loginEmail")
    val loginEmail: String,

    @Column(nullable = false)
    val senha: String,

    @OneToOne
    @JoinColumn(name = "id_Pessoa", unique = true)
    val pessoa: Pessoa,

    @Column(nullable = false)
    val habilitado: Boolean,

    @Column(name = "emailValido")
    val emailValido: Boolean?
)

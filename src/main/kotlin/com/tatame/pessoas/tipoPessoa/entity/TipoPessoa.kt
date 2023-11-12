package com.tatame.pessoas.tipoPessoa.entity

import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.pessoas.contratante.entity.Contratante
import com.tatame.pessoas.professor.entity.Professor
import com.tatame.pessoas.usuario.entity.Usuario
import jakarta.persistence.*


@Entity
@Table(name = "TipoPessoa")
data class TipoPessoa(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    val id: Int,

    @Column(nullable = false)
    val descricao: String
)
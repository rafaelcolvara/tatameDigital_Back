package com.arena.usuario.entity

import com.arena.pessoas.competidor.entity.Competidor
import com.arena.pessoas.contratante.entity.Contratante
import com.arena.pessoas.professor.entity.Professor
import com.arena.pessoas.usuario.entity.Usuario
import jakarta.persistence.*


@Entity
@Table(name = "TipoPessoa")
data class TipoPessoa(

    @Id
    @OneToOne
    @JoinColumn(name = "id_Professor")
    val professor: Professor?,  // Assuming that you have a Professor entity

    @OneToOne
    @JoinColumn(name = "id_Usuario")
    val usuario: Usuario?,

    @OneToOne
    @JoinColumn(name = "id_Competidor")
    val competidor: Competidor?,  // Assuming that you have a Competidor entity

    @OneToOne
    @JoinColumn(name = "id_Contratante")
    val contratante: Contratante?
)
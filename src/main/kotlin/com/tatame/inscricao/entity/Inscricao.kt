package com.tatame.inscricao.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.tatame.endereco.entity.Cidade
import com.tatame.evento.entity.Evento
import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.regulamentoCategoria.entity.RegulamentoCategoria
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Inscricao")
data class Inscricao(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    val id: Int? = null,

    @Column(name = "pago", nullable = false)
    val pago: Boolean,

    @Column(name = "dtInscricao", nullable = false)
    val dtIncricao: LocalDateTime?,

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "id_Evento", nullable = false)
    val id_Evento: Evento,

    @OneToOne()
    @JoinColumn(name = "id_Competidor")
    val id_Competidor: Competidor,

    @OneToOne()
    @JoinColumn(name = "id_Categoria")
    val regulamentoCategoria: RegulamentoCategoria

)

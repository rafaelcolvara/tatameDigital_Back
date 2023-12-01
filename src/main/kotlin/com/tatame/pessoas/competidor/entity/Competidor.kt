package com.tatame.pessoas.competidor.entity


import com.tatame.academia.entity.Academia
import com.tatame.faixa.entity.Faixa
import com.tatame.pessoas.pessoa.entity.Pessoa
import jakarta.persistence.*

@Entity
@Table(name = "Competidor")
class Competidor(


    @Id
    var id: Int? = null,  // Garanta que este seja do mesmo tipo que o ID de Pessoa

    @ManyToOne
    @JoinColumn(name = "id_Academia")
    val academia: Academia?,

    @ManyToOne
    @JoinColumn(name = "id_Faixa")
    val faixa: Faixa?,

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_Pessoa")
    val pessoa: Pessoa,

    @Column(name = "peso")
    val peso: Double

 )

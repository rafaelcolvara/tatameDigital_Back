package com.tatame.pessoas.competidor.entity


import com.tatame.academia.entity.Academia
import com.tatame.conf.Util
import com.tatame.faixa.entity.Faixa
import com.tatame.pessoas.pessoa.d EnumCategoriaIdade
import com.tatame.pessoas.pessoa.entity.Pessoa
import jakarta.persistence.*
import java.time.LocalDate
import java.time.Period



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

    @Transient
    var categoriaIdade: EnumCategoriaIdade
){


    @PostLoad
    @PrePersist
    @PreUpdate
    private fun onLoading() {
        this.categoriaIdade =  Util.determineAgeCategory(this.pessoa.dataNascimento!! )
    }
}

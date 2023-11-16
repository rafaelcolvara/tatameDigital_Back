package com.tatame.endereco.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*

@Entity
@Table(name = "Cidade")
data class Cidade(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "nome", nullable = false)
    var nome: String,

    @OneToMany(mappedBy = "cidade", fetch =FetchType.LAZY)
    @JsonManagedReference
    var enderecos: List<Endereco> = mutableListOf()

){
    override fun toString(): String {
        return "Cidade(id=$id, nome='$nome')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cidade

        if (id != other.id) return false
        if (nome != other.nome) return false
        return enderecos == other.enderecos
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + nome.hashCode()
        result = 31 * result + enderecos.hashCode()
        return result
    }

}

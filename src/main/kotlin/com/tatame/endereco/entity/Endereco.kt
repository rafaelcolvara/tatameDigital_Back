package com.tatame.endereco.entity


import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*

@Entity
@Table(name = "Endereco")
data class Endereco(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column(name = "rua", nullable = false, length = 100)
    var rua: String,

    @Column(name = "complemento", length = 50)
    var complemento: String? = null,

    @Column(name = "numero")
    var numero: Int? = null,

    @Column(name = "cep", length = 9)
    var cep: String? = null,

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "id_cidade", nullable = false)
    val cidade: Cidade

)
{
    override fun toString(): String {
        return "Endereco(id=$id, rua='$rua', complemento=$complemento, numero=$numero, cep=$cep, cidade=${cidade.nome})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (id != other.id) return false
        if (rua != other.rua) return false
        if (complemento != other.complemento) return false
        if (numero != other.numero) return false
        if (cep != other.cep) return false
        return cidade == other.cidade
    }

    override fun hashCode(): Int {
        var result = id ?: 0
        result = 31 * result + rua.hashCode()
        result = 31 * result + (complemento?.hashCode() ?: 0)
        result = 31 * result + (numero ?: 0)
        result = 31 * result + (cep?.hashCode() ?: 0)
        result = 31 * result + cidade.hashCode()
        return result
    }


}

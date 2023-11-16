package com.tatame.endereco.repository

import com.tatame.endereco.entity.Cidade
import com.tatame.endereco.entity.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository: JpaRepository<Cidade, Int>

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Int> {
    @Query("SELECT e FROM Endereco e ")
    fun findAllEnderecos(): List<Endereco>
}
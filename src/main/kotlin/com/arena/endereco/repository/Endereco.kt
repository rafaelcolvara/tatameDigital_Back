package com.arena.endereco.repository

import com.arena.endereco.entity.Cidade
import com.arena.endereco.entity.Endereco
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CidadeRepository: JpaRepository<Cidade, Int>

@Repository
interface EnderecoRepository: JpaRepository<Endereco, Int>

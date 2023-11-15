package com.tatame.pessoas.pessoa.repository

import com.tatame.pessoas.pessoa.entity.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository : JpaRepository<Pessoa, Int>
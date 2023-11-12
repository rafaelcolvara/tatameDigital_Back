package com.tatame.inscricao.repository

import com.tatame.inscricao.entity.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository : JpaRepository<Inscricao, Int> {
}
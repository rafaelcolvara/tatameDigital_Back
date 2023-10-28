package com.arena.inscricao.repository

import com.arena.inscricao.entity.Inscricao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InscricaoRepository : JpaRepository<Inscricao, Int> {
}
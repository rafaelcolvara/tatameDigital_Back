package com.arena.inscricao.repository

import com.arena.inscricao.entity.Inscricao
import org.springframework.data.jpa.repository.JpaRepository

interface InscricaoRepository : JpaRepository<Inscricao, Int> {
}
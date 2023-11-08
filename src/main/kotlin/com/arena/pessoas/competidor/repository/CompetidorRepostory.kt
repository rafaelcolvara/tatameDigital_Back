package com.arena.pessoas.competidor.repository

import com.arena.pessoas.competidor.entity.Competidor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompetidorRepository : JpaRepository<Competidor, Short>


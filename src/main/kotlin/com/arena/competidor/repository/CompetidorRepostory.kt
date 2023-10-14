package com.arena.competidor.repository

import com.arena.competidor.entity.Competidor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompetidorRepository : JpaRepository<Competidor, Short>


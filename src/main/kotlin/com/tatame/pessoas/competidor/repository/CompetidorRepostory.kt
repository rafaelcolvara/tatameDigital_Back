package com.tatame.pessoas.competidor.repository

import com.tatame.pessoas.competidor.entity.Competidor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CompetidorRepository : JpaRepository<Competidor, Int>


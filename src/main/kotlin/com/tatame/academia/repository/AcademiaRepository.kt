package com.tatame.academia.repository

import com.tatame.academia.entity.Academia
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AcademiaRepository: JpaRepository<Academia, Int>
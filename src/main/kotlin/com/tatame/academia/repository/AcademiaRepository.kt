package com.tatame.academia.repository

import com.tatame.academia.entity.Academia
import org.springframework.data.jpa.repository.JpaRepository

interface AcademiaRepository: JpaRepository<Academia, Int>
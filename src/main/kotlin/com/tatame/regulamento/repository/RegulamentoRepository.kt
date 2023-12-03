package com.tatame.regulamento.repository

import com.tatame.regulamento.entity.RegulamentoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  RegulamentoRepository: JpaRepository<RegulamentoEntity, Int>
package com.tatame.regulamentoCategoria.repository

import com.tatame.regulamentoCategoria.entity.RegulamentoCategoria
import org.springframework.data.jpa.repository.JpaRepository

interface RegulamentoCategoriaRepository: JpaRepository<RegulamentoCategoria, Int > {
}
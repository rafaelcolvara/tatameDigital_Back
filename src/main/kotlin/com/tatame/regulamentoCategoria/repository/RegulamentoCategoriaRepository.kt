package com.tatame.regulamentoCategoria.repository

import com.tatame.regulamento.entity.RegulamentoCategoriaPK
import com.tatame.regulamentoCategoria.entity.RegulamentoCategoria
import org.springframework.data.jpa.repository.JpaRepository

interface RegulamentoCategoriaRepository: JpaRepository<RegulamentoCategoria, Int > {
}
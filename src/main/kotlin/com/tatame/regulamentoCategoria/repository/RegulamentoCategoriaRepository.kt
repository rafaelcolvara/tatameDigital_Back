package com.tatame.regulamentoCategoria.repository

import com.tatame.regulamentoCategoria.entity.RegulamentoCategoriaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RegulamentoCategoriaRepository: JpaRepository<RegulamentoCategoriaEntity, Int > {
}
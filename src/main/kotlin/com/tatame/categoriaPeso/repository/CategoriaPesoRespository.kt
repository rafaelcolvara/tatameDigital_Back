package com.tatame.categoriaPeso.repository

import com.tatame.categoriaPeso.entity.CategoriaPeso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaPesoRespository: JpaRepository<CategoriaPeso, Int> {
}
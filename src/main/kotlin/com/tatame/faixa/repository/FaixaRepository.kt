package com.tatame.faixa.repository

import com.tatame.faixa.entity.Faixa
import org.springframework.data.jpa.repository.JpaRepository

interface FaixaRepository : JpaRepository<Faixa, Int>
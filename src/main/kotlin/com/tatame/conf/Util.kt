package com.tatame.conf

import com.tatame.pessoas.pessoa.EnumCategoriaIdade
import java.time.LocalDate
import java.time.Period

object Util {
    fun determineAgeCategory(birthDate: LocalDate): EnumCategoriaIdade {
        val age = calculateAge(birthDate)

        return when {
            age in 4 .. 5 -> EnumCategoriaIdade.KIDS_1
            age in 6..7 -> EnumCategoriaIdade.KIDS_2
            age in 8..9 -> EnumCategoriaIdade.KIDS_3
            age in 10..11 -> EnumCategoriaIdade.INFANTIL
            age in 12..13 -> EnumCategoriaIdade.JUNIOR
            age in 14..15 -> EnumCategoriaIdade.ADOLECENTE
            age in 16..17 -> EnumCategoriaIdade.JUVENIL
            age in 18..29 -> EnumCategoriaIdade.ADULTO
            age in 30..35 -> EnumCategoriaIdade.MASTER_1
            age in 36..40 -> EnumCategoriaIdade.MASTER_2
            age in 41..45 -> EnumCategoriaIdade.MASTER_3

            else -> EnumCategoriaIdade.MASTER_4
        }
    }
    fun calculateAge(birthDate: LocalDate): Int {
        return Period.between(birthDate, LocalDate.now()).years
    }

}
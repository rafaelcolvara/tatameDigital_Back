package com.tatame.conf


import com.tatame.categoria.enums.EnumCategoriaIdade_FBJJ
import com.tatame.categoria.enums.EnumCategoriaIdade_FJJPR
import com.tatame.categoria.interfaces.TipoCampeonato
import java.time.LocalDate
import java.time.Period

object Util {
    fun  determineAgeCategory(birthDate: LocalDate): TipoCampeonato {
        val age = calculateAge(birthDate)

        return when {
            age in 4 .. 5 -> EnumCategoriaIdade_FBJJ.KIDS_1
            age in 6..7 -> EnumCategoriaIdade_FBJJ.KIDS_2
            age in 8..9 -> EnumCategoriaIdade_FBJJ.KIDS_3
            age in 10..11 -> EnumCategoriaIdade_FBJJ.INFANTIL
            age in 12..13 -> EnumCategoriaIdade_FBJJ.JUNIOR
            age in 14..15 -> EnumCategoriaIdade_FBJJ.ADOLECENTE
            age in 16..17 -> EnumCategoriaIdade_FBJJ.JUVENIL
            age in 18..29 -> EnumCategoriaIdade_FBJJ.ADULTO
            age in 30..35 -> EnumCategoriaIdade_FBJJ.MASTER_1
            age in 36..40 -> EnumCategoriaIdade_FBJJ.MASTER_2
            age in 41..45 -> EnumCategoriaIdade_FBJJ.MASTER_3

            else -> EnumCategoriaIdade_FBJJ.MASTER_4
        }
    }
    fun calculateAge(birthDate: LocalDate): Int {
        return Period.between(birthDate, LocalDate.now()).years
    }

}
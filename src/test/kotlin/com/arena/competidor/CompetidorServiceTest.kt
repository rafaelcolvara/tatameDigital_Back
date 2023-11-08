package com.arena.competidor

import com.arena.pessoas.competidor.entity.Competidor
import com.arena.pessoas.competidor.entity.CompetidorForm
import com.arena.pessoas.competidor.repository.CompetidorRepository
import com.arena.pessoas.competidor.service.CompetidorService
import com.arena.endereco.entity.Cidade
import com.arena.endereco.entity.CidadeForm
import com.arena.endereco.entity.Endereco
import com.arena.endereco.entity.EnderecoForm
import com.arena.endereco.service.EnderecoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import org.mockito.kotlin.anyOrNull
import java.util.*

class CompetidorServiceTest {

    private lateinit var service: CompetidorService
    private lateinit var repository: CompetidorRepository
    private lateinit var enderecoService: EnderecoService

    @BeforeEach
    fun setUp() {
        repository = mock(CompetidorRepository::class.java)
        enderecoService = mock(EnderecoService::class.java)
        service = CompetidorService(repository, enderecoService)
    }

    @Test
    fun testFindAll() {
        // Arrange
        val competidores = listOf(
            Competidor(1, "Competidor 1", Date(), null, null, 1),
            Competidor(2, "Competidor 2", Date(), null, null, 2)
        )
        `when`(repository.findAll()).thenReturn(competidores)

        // Act
        val result = service.findAll()

        // Assert
        assertEquals(2, result.size)
    }

    @Test
    fun testFindById() {
        // Arrange
        val competidor = Competidor(1, "Competidor 1", Date(), null, null, 1)
        `when`(repository.findById(1.toShort())).thenReturn(Optional.of(competidor))

        // Act
        val result = service.findById(1.toShort())

        // Assert
        assertNotNull(result)
        assertEquals(1, result?.id)
    }

    @Test
    fun testSave() {
        // Arrange
        val competidorForm = CompetidorForm("New Competidor", Date(), null, null, EnderecoForm("Rua", "", 0,"11630-000", CidadeForm("Cidade" ) ))
        val endereco = Endereco(1, "Address", "", 1, "09090909", Cidade(1, "Carapicuba" )
        )
        `when`(enderecoService.save(anyOrNull())).thenReturn(endereco)
        `when`(repository.save(any())).thenAnswer { invocation ->
            val savedCompetidor = invocation.arguments[0] as Competidor
            savedCompetidor.copy(id = 1)
        }

        // Act
        val result = service.save(competidorForm)

        // Assert
        assertNotNull(result)
        assertEquals(1, result.id)
        assertEquals("New Competidor", result.nome)
    }

    @Test
    fun testDeleteById() {
        // Arrange
        val competidorIdToDelete = 1.toShort()

        // Act
        service.deleteById(competidorIdToDelete)

        // Assert
        verify(repository, times(1)).deleteById(competidorIdToDelete)
    }
}

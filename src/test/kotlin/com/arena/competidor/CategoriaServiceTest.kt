package com.arena.competidor

import com.arena.categoria.entity.Categoria
import com.arena.categoria.entity.CategoriaForm
import com.arena.categoria.repository.CategoriaRepository
import com.arena.categoria.service.CategoriaService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*

@SpringBootTest
class CategoriaServiceTest {

    @MockBean
    private lateinit var categoriaRepository: CategoriaRepository

    private lateinit var categoriaService: CategoriaService

    @BeforeEach
    fun setUp() {
        categoriaService = CategoriaService(categoriaRepository)
    }

    @Test
    fun `test findAll`() {
        val categories = listOf(Categoria(id = 1, nome = "Category1"), Categoria(id = 2, nome = "Category2"))
        `when`(categoriaRepository.findAll()).thenReturn(categories)

        val result = categoriaService.findAll()

        assertEquals(categories, result)
    }

    @Test
    fun `test findById`() {
        val category = Categoria(id = 1, nome = "Category1")
        `when`(categoriaRepository.findById(1)).thenReturn(Optional.of(category))

        val result = categoriaService.findById(1)

        assertEquals(category, result)
    }

    @Test
    fun `test findById not found`() {
        `when`(categoriaRepository.findById(999)).thenReturn(Optional.empty())

        val result = categoriaService.findById(999)

        assertNull(result)
    }

    @Test
    fun `test save`() {
        val categoriaForm = CategoriaForm(nome = "NewCategory")
        val savedCategory = Categoria(id = 1, nome = "NewCategory")

        `when`(categoriaRepository.save(any())).thenReturn(savedCategory)

        val result = categoriaService.save(categoriaForm)

        assertEquals(savedCategory, result)
    }

    @Test
    fun `test deleteById`() {
        doNothing().`when`(categoriaRepository).deleteById(1)

        categoriaService.deleteById(1)

        verify(categoriaRepository, times(1)).deleteById(1)
    }
}



package com.tatame.regulamentoCategoria.controller

import com.tatame.regulamentoCategoria.entity.RegulamentoCategoriaEntity
import com.tatame.regulamentoCategoria.entity.RegulamentoCategoriaForm
import com.tatame.regulamentoCategoria.service.RegulamentoCategoriaService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Regulamento - Categoria: Relação entre categorias por entidade ")
@RestController
@RequestMapping("/regulamentoCategoria")
class RegulamentoCategoriaController(val regulamentoCategoriaService: RegulamentoCategoriaService) {

    @PostMapping
    fun create(@RequestBody regulamentoCategoriaForm: RegulamentoCategoriaForm): ResponseEntity<RegulamentoCategoriaEntity> {
        return ResponseEntity.ok(regulamentoCategoriaService.save(regulamentoCategoriaForm))
    }

    @GetMapping("/all")
    fun getAll(): List<RegulamentoCategoriaEntity> = regulamentoCategoriaService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<RegulamentoCategoriaEntity> {
        try{
            val regulamentoCategoria = regulamentoCategoriaService.findById(id)
            return ResponseEntity.ok(regulamentoCategoria)
        }
        catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedRegulamentoCategoria: RegulamentoCategoriaForm): ResponseEntity<RegulamentoCategoriaEntity> {
        try {
            val categoriaIdadeEntity = regulamentoCategoriaService.findById(id);
            updatedRegulamentoCategoria.id = categoriaIdadeEntity.id
            return ResponseEntity.ok(regulamentoCategoriaService.save(updatedRegulamentoCategoria))
        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        try {
            regulamentoCategoriaService.findById(id)
            regulamentoCategoriaService.deleteById(id)
            return ResponseEntity.noContent().build()
        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }
    }
}
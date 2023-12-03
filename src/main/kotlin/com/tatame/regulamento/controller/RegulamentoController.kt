package com.tatame.regulamento.controller

import com.tatame.regulamento.entity.RegulamentoEntity
import com.tatame.regulamento.entity.RegulamentoForm
import com.tatame.regulamento.service.RegulamentoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name = "Regulamento do Campeonato (CBJJ, CBJJE, CBJJ,...")
@RestController
@RequestMapping("/regulamento")
class RegulamentoController(val regulamentoService: RegulamentoService) {

    @PostMapping
    fun create(@RequestBody regulamentoForm: RegulamentoForm): ResponseEntity<RegulamentoEntity> {
        return ResponseEntity.ok(regulamentoService.save(regulamentoForm))
    }

    @GetMapping("/all")
    fun getAll(): List<RegulamentoEntity> = regulamentoService.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): ResponseEntity<RegulamentoEntity> {
        try{
            val regulamento = regulamentoService.findById(id)
            return ResponseEntity.ok(regulamento)
        }
        catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody updatedRegulamento: RegulamentoForm): ResponseEntity<RegulamentoEntity> {
        try {
            val regulamentoEntity = regulamentoService.findById(id);
            updatedRegulamento.id = regulamentoEntity.id
            return ResponseEntity.ok(regulamentoService.save(updatedRegulamento))

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<Void> {
        try {
            regulamentoService.findById(id)
            regulamentoService.deleteById(id)
            return ResponseEntity.noContent().build()

        }catch (e: Exception){
            return ResponseEntity.notFound().build()
        }
    }

}
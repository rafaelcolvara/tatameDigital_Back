package com.tatame.endereco.controller

import com.tatame.endereco.entity.Endereco
import com.tatame.endereco.entity.EnderecoForm
import com.tatame.endereco.service.EnderecoService
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Enderecos")
@RestController
@RequestMapping("/enderecos")
data class EnderecoController(private val enderecoService: EnderecoService){

    @PostMapping
    fun create(@RequestBody endereco: EnderecoForm): ResponseEntity<Endereco> {
        return ResponseEntity.ok(enderecoService.save(endereco))
    }

    @GetMapping("/all")
    fun getAll(): List<Endereco> = enderecoService.findAll()


}

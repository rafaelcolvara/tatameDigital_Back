package com.arena.endereco.service

import com.arena.endereco.entity.Endereco
import com.arena.endereco.entity.EnderecoForm
import com.arena.endereco.repository.EnderecoRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
@Transactional
class EnderecoService(private val enderecoRepository: EnderecoRepository,
private val cidadeService: CidadeService) {
    fun findAll(): List<Endereco> = enderecoRepository.findAll()
    fun save(endereco: EnderecoForm): Endereco {
        return enderecoRepository.save(
            Endereco(
                rua = endereco.rua,
                complemento = endereco.complemento,
                numero = endereco.numero,
                cep = endereco.cep,
                cidade = cidadeService.save(endereco.cidade)
            )
        )
    }

}



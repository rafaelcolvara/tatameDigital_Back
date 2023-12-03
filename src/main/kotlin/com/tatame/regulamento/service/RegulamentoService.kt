package com.tatame.regulamento.service
import com.tatame.regulamento.entity.RegulamentoEntity
import com.tatame.regulamento.entity.RegulamentoForm
import com.tatame.regulamento.repository.RegulamentoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RegulamentoService(val regulamentoRepository: RegulamentoRepository) {

    fun findAll(): List<RegulamentoEntity> = regulamentoRepository.findAll()

    @Transactional
    fun save(regulamento: RegulamentoForm): RegulamentoEntity {
        return regulamentoRepository.save(
            RegulamentoEntity(
            id = regulamento.id,
            nome = regulamento.nome,
            sigla = regulamento.sigla)
        )
    }

    fun findById(id: Int): RegulamentoEntity {
        return regulamentoRepository.findById(id).orElseThrow { NoSuchElementException("Regulamento não cadastrado ${id}") }
    }

    @Transactional
    fun deleteById(id: Int) = regulamentoRepository.deleteById(id)


}
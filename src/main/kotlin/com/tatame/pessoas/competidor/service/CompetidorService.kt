package com.tatame.pessoas.competidor.service

import com.tatame.academia.entity.Academia
import com.tatame.endereco.entity.Cidade
import com.tatame.endereco.entity.Endereco
import com.tatame.pessoas.competidor.entity.Competidor
import com.tatame.pessoas.competidor.entity.CompetidorForm
import com.tatame.pessoas.competidor.repository.CompetidorRepository
import com.tatame.endereco.service.EnderecoService
import com.tatame.faixa.entity.Faixa
import com.tatame.pessoas.pessoa.entity.Pessoa
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompetidorService(
    private val repository: CompetidorRepository,
    private val enderecoService: EnderecoService
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Competidor> = repository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Short): Competidor? = repository.findById(id).orElse(null)

    @Transactional
    fun save(competidor: CompetidorForm): Competidor = repository.save(
        Competidor(
            academia = Academia(nome = competidor.academia.nome, id = competidor.academia.id, pessoa = null ),
            faixa = Faixa(competidor.faixa.id, competidor.faixa.cor),
            pessoa = Pessoa(id= competidor.pessoa.id,
                nome= competidor.pessoa.nome,
                dataNascimento = competidor.pessoa.dataNascimento,
                celular = competidor.pessoa.celular,
                cpfCnpj = competidor.pessoa.cpfCnpj,
                foto = competidor.pessoa.foto,
                endereco = Endereco(id = competidor.pessoa.endereco!!.id, rua = competidor.pessoa.endereco.rua, numero = competidor.pessoa.endereco.numero, complemento = competidor.pessoa.endereco.complemento, cep = competidor.pessoa.endereco.cep, cidade = Cidade(id= competidor.pessoa.endereco.cidade.id, nome = competidor.pessoa.endereco.cidade.nome ))
            )
        )
    )

    @Transactional
    fun deleteById(id: Short) = repository.deleteById(id)

}


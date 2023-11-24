package com.tatame.pessoas.pessoa.service


import com.tatame.endereco.entity.Endereco
import com.tatame.endereco.entity.EnderecoForm
import com.tatame.endereco.service.EnderecoService

import com.tatame.pessoas.pessoa.entity.Pessoa
import com.tatame.pessoas.pessoa.entity.PessoaForm
import com.tatame.pessoas.pessoa.repository.PessoaRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.time.Period
import java.util.*
import kotlin.NoSuchElementException

@Service
class PessoaService(private val pessoaRepository: PessoaRepository,
                    private val enderecoService: EnderecoService
) {
    @Transactional(readOnly = true)
    fun findAll(): List<Pessoa> = pessoaRepository.findAll()

    @Transactional(readOnly = true)
    fun findById(id: Int): Pessoa? = pessoaRepository.findById(id).orElse(null)

    @Transactional(readOnly = true)
    fun deleteById(id: Int)  = pessoaRepository.deleteById(id)

    @Transactional(readOnly = false)
    fun updatePersonalData(id: Int, pessoaForm: PessoaForm): Pessoa {

        var pessoaUpdate: Pessoa = pessoaRepository.findById(id).orElseThrow { NoSuchElementException("Pessoa com código ${id} não encontrada") }
        if( !Objects.isNull(pessoaForm.dataNascimento) ) pessoaForm.dataNascimento.let { pessoaUpdate.dataNascimento = it!!}
        if( !Objects.isNull(pessoaForm.dddCelular) ) pessoaForm.dddCelular.let {  pessoaUpdate.dddCelular = it!! }
        if( !Objects.isNull(pessoaForm.celular) ) pessoaForm.celular.let { pessoaUpdate.celular = it!!}
        if( !Objects.isNull(pessoaForm.foto) ) pessoaForm.foto.let {pessoaUpdate.foto = it!!}
        if( !Objects.isNull(pessoaForm.foto) ) pessoaForm.nome.let { pessoaUpdate.nome = it!!}

        return pessoaRepository.save(pessoaUpdate)

    }


    @Transactional
    fun saveFullData(pessoa: PessoaForm): Pessoa {

        val endereco: Endereco = enderecoService.save(
            EnderecoForm(
                rua = pessoa.endereco!!.rua,
                numero = pessoa.endereco.numero,
                complemento = pessoa.endereco.complemento,
                cep = pessoa.endereco.cep,
                idCidade =  pessoa.endereco!!.idCidade
        ))

        return pessoaRepository.save(Pessoa(
            id = null,
            nome = pessoa.nome!!,
            dataNascimento = pessoa.dataNascimento,
            celular = pessoa.celular!!,
            cpfCnpj = pessoa.cpfCnpj,
            dddCelular = pessoa.dddCelular!!,
            foto = pessoa.foto,
            endereco = endereco) )


    }




}
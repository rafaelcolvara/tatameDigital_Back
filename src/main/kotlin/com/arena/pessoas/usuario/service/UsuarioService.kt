package com.arena.pessoas.usuario.service


import com.arena.pessoas.usuario.entity.Usuario
import com.arena.pessoas.usuario.repository.UsuarioRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository) {

    @Transactional(readOnly = true)
    fun findByEmail(email: String): Usuario? = usuarioRepository.findByEmail(email).orElse(null)

    @Transactional(readOnly = true)
    fun findByEmailAndSenha(email: String, senha: String): Usuario? = usuarioRepository.findByEmailAndPassword(email, senha).orElse(null)


}
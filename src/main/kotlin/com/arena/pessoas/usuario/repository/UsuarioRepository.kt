package com.arena.pessoas.usuario.repository

import com.arena.pessoas.usuario.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface UsuarioRepository : JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.email = :email")
    fun findByEmail(email: String): Optional<Usuario>

    @Query("SELECT u FROM Usuario u WHERE u.email = :email and u.senha = :pass")
    fun findByEmailAndPassword(email: String, pass: String): Optional<Usuario>


}
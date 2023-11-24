package com.tatame.conf

import com.tatame.pessoas.usuario.entity.Usuario
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*
import kotlin.collections.HashMap

@Component
class JWTUtil {
    @Value("\${jwt.meu_secret}")
    private lateinit var secret: String

    fun generateToken(userDetails: Usuario): String {
        val claims: Map<String, Object> = HashMap()
        return createToken(claims, userDetails.loginEmail)
    }

    private fun createToken(claims: Map<String, Object>, subject: String): String {
        return Jwts.builder().setClaims(claims).setSubject(subject)
            .setIssuedAt(Date(System.currentTimeMillis()))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
            .signWith(SignatureAlgorithm.HS256, secret).compact()
    }
}
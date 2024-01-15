package com.tatame

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/is-alive")
class IsAlive {
    val logger = LoggerFactory.getLogger(IsAlive::class.java)

    @GetMapping
    fun isAlive():Boolean{
        logger.info("Consulta /is-alive")
        return true
    }
}
package com.arena

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/is-alive")
class IsAlive {

    @GetMapping
    fun isAlive(): Boolean = true
    
}
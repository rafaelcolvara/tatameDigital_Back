package com.tatame

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TatameApplication

fun main(args: Array<String>) {
	runApplication<TatameApplication>(*args)
}

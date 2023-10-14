package com.arena

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ArenaApplication

fun main(args: Array<String>) {
	runApplication<ArenaApplication>(*args)
}

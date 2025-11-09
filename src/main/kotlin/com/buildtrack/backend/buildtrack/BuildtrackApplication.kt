package com.buildtrack.backend.buildtrack

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BuildtrackApplication

fun main(args: Array<String>) {
	runApplication<BuildtrackApplication>(*args)
}

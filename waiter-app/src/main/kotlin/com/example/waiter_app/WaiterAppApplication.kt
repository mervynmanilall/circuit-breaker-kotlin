package com.example.waiter_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WaiterAppApplication

fun main(args: Array<String>) {
	runApplication<WaiterAppApplication>(*args)
}

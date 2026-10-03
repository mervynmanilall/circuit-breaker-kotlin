package com.example.kitchen_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KitchenAppApplication

fun main(args: Array<String>) {
	runApplication<KitchenAppApplication>(*args)
}

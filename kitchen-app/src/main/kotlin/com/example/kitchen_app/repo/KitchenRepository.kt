package com.example.kitchen_app.repo

import com.example.kitchen_app.Models.Dish
import org.springframework.stereotype.Repository

@Repository
class KitchenRepository {
    private val menu = listOf(
        Dish("brochette", "grill"),
        Dish("napolitaine", "dessert"),
    )

    fun findDish(name: String, station: String): Dish? =
        menu.find { it.name == name && it.station == station }
}
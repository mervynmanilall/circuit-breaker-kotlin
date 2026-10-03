package com.example.kitchen_app.service

import com.example.kitchen_app.Models.Ticket
import com.example.kitchen_app.repo.KitchenRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class KitchenService(private val repository: KitchenRepository) {

    @Volatile var grillMode = "ok"   // "ok", "slow" or "burnt"

    fun cook(dishName: String, station: String): Ticket {
        val dish = repository.findDish(dishName, station)
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "$dishName is not on the menu")

        if (station == "grill" && grillMode == "slow") Thread.sleep(5000)
        if (station == "grill" && grillMode == "burnt")
            throw ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The grill burnt the dish")

        return Ticket(dish.name, "Cooked by the $station")
    }
}
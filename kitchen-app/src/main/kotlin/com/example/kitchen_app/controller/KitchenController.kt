package com.example.kitchen_app.controller

import com.example.kitchen_app.service.KitchenService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class KitchenController(private val service: KitchenService) {

    @GetMapping("/grill")
    fun grill(@RequestParam dish: String) = service.cook(dish, "grill")

    @GetMapping("/dessert")
    fun dessert(@RequestParam dish: String) = service.cook(dish, "dessert")

    @PostMapping("/grill/mode")
    fun setGrillMode(@RequestParam mode: String): String {
        service.grillMode = mode
        return "Grill mode is now $mode"
    }
}
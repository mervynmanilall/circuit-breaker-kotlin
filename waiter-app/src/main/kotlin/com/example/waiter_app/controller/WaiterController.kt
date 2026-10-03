package com.example.waiter_app.controller

import com.example.waiter_app.service.WaiterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WaiterController(private val service: WaiterService) {
    @GetMapping("/order/grill")
    fun grill(@RequestParam dish: String) = service.orderGrill(dish)

    @GetMapping("/order/dessert")
    fun dessert(@RequestParam dish: String) = service.orderDessert(dish)
}
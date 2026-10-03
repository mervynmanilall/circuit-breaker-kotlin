package com.example.waiter_app.service

import com.example.waiter_app.models.Ticket
import com.example.waiter_app.repo.WaiterRepository
import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service

// before adding the circuit breaker
@Service
class WaiterService(private val repository: WaiterRepository) {

    fun orderGrill(dish: String): Ticket = repository.askGrill(dish)

    fun orderDessert(dish: String): Ticket = repository.askDessert(dish)
}

//@Service
//class WaiterService(private val repository: WaiterRepository) {
//
//    @CircuitBreaker(name = "grill", fallbackMethod = "offerSalad")
//    fun orderGrill(dish: String): Ticket = repository.askGrill(dish)
//
//    @CircuitBreaker(name = "dessert", fallbackMethod = "offerFruit")
//    fun orderDessert(dish: String): Ticket = repository.askDessert(dish)
//
//    fun offerSalad(dish: String, e: CallNotPermittedException) =
//        Ticket("salad", "Grill unavailable, $dish replaced by a salad")
//
//    fun offerFruit(dish: String, e: CallNotPermittedException) =
//        Ticket("fruit", "Dessert station unavailable")
//}
package com.example.waiter_app.repo

import com.example.waiter_app.models.Ticket
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestClient
import org.springframework.web.client.body
import java.time.Duration


@Repository
class WaiterRepository {
    private val kitchen = RestClient.builder()
        .baseUrl("http://localhost:8081")
        .requestFactory(SimpleClientHttpRequestFactory().apply {
            setReadTimeout(Duration.ofSeconds(3))   // give up after 3 s
        })
        .build()

    fun askGrill(dish: String): Ticket =
        kitchen.get().uri("/grill?dish={dish}", dish).retrieve().body<Ticket>()!!

    fun askDessert(dish: String): Ticket =
        kitchen.get().uri("/dessert?dish={dish}", dish).retrieve().body<Ticket>()!!
}
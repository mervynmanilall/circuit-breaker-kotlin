package com.example.kitchen_app.Models

data class Dish(val name: String, val station: String)   // station: "grill" or "dessert"
data class Ticket(val dish: String, val note: String)

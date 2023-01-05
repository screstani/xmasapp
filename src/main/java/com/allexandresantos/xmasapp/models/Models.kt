package com.allexandresantos.xmasapp.models

data class OrderModel(
    val orderDetails: String,
    val orderId: String = "",
    val userId: String,
    val orderStatus: OrderStatus? = null,
    val products: List<Product> = listOf(),
    val totalPrice: String = "",
    val isPayed: Boolean = false
)

data class UserModel(
    val userId: String = "",
    val userName: String = ""
)

enum class OrderStatus { CREATED, IN_PROGRESS, WAITING_PAYMENT, COMPLETED, RETIRED }

data class Product(val id: String, val name: String = "", val price: String = "", val quantity: String = "")


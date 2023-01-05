package com.allexandresantos.xmasapp.entities

import com.allexandresantos.xmasapp.models.OrderStatus
import com.allexandresantos.xmasapp.models.Product

data class OrderEntity(
    val orderDetails: String,
    val orderId: String = "",
    val userId: String,
    val orderStatus: OrderStatus? = null,
    val products: List<Product> = listOf(),
    val totalPrice: String = ""
)

data class UserEntity(
    val userId: String = "",
    val userName: String = ""
)


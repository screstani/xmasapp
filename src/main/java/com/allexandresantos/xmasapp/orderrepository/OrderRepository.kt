package com.allexandresantos.xmasapp.orderrepository

import com.allexandresantos.xmasapp.models.OrderModel

interface OrderRepository {
    suspend fun placeOrder(orderModel: OrderModel): Result<OrderModel>
    suspend fun editOrder(orderModel: OrderModel): Result<OrderModel>
}
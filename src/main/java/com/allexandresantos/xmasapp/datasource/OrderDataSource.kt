package com.allexandresantos.xmasapp.datasource

import com.allexandresantos.xmasapp.entities.OrderEntity

interface OrderDataSource {
    suspend fun placeOrder(orderEntity: OrderEntity): Result<OrderEntity>
    suspend fun editOrder(orderEntity: OrderEntity): Result<OrderEntity>
}
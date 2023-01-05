package com.allexandresantos.xmasapp.datasource

import com.allexandresantos.xmasapp.entities.OrderEntity
import com.allexandresantos.xmasapp.models.OrderStatus
import kotlinx.coroutines.delay
import java.util.UUID
import javax.inject.Inject

class OrderDataSourceImpl @Inject constructor(): OrderDataSource {
    override suspend fun placeOrder(orderEntity: OrderEntity): Result<OrderEntity> {
        delay(2000)
        return runCatching {
            Result.success(
                OrderEntity(
                    orderDetails = orderEntity.orderDetails,
                    orderId = UUID.randomUUID().toString(),
                    userId = orderEntity.userId,
                    orderStatus = OrderStatus.CREATED,
                    products = orderEntity.products,
                    totalPrice = orderEntity.totalPrice
                )
            )
        }.getOrElse { e->
            Result.failure(e)
        }
    }

    override suspend fun editOrder(orderEntity: OrderEntity): Result<OrderEntity> {
        delay(2000)
        return runCatching {
            Result.success(
                OrderEntity(
                    orderDetails = orderEntity.orderDetails,
                    orderId = orderEntity.orderId,
                    userId = orderEntity.userId,
                    orderStatus = OrderStatus.CREATED,
                    products = orderEntity.products,
                    totalPrice = orderEntity.totalPrice
                )
            )
        }.getOrElse { e->
            Result.failure(e)
        }
    }
}
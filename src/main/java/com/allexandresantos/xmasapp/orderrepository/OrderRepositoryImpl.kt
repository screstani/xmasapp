package com.allexandresantos.xmasapp.orderrepository

import com.allexandresantos.xmasapp.datasource.OrderDataSource
import com.allexandresantos.xmasapp.mapper.OrderMapper
import com.allexandresantos.xmasapp.models.OrderModel
import javax.inject.Inject

class OrderRepositoryImpl @Inject constructor(
    private val orderDataSource: OrderDataSource,
    private val orderMapper: OrderMapper
): OrderRepository {
    override suspend fun placeOrder(orderModel: OrderModel): Result<OrderModel> {
        val dataSourceResponse = orderDataSource.placeOrder(orderMapper.from(orderModel))
        val result = dataSourceResponse.fold(
            onSuccess = {
                Result.success(orderMapper.to(it))
            },
            onFailure = {
                Result.failure(it)
            }
        )
        return result
    }

    override suspend fun editOrder(orderModel: OrderModel): Result<OrderModel> {
        val dataSourceResponse = orderDataSource.editOrder(orderMapper.from(orderModel))
        val result = dataSourceResponse.fold(
            onSuccess = {
                Result.success(orderMapper.to(it))
            },
            onFailure = {
                Result.failure(it)
            }
        )
        return result    }

}
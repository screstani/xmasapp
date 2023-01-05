package com.allexandresantos.xmasapp.mapper

import com.allexandresantos.xmasapp.entities.OrderEntity
import com.allexandresantos.xmasapp.models.OrderModel
import javax.inject.Inject

class OrderMapper @Inject constructor(){

    fun to(entity: OrderEntity): OrderModel{
        return OrderModel(
            orderDetails = entity.orderDetails,
        orderId = entity.orderId,
         userId = entity.userId,
         orderStatus = entity.orderStatus,
         products = entity.products,
        totalPrice = entity.totalPrice
        )
    }

    fun from(model: OrderModel): OrderEntity{
        return OrderEntity(
            orderDetails = model.orderDetails,
            orderId = model.orderId,
            userId = model.userId,
            orderStatus = model.orderStatus,
            products = model.products,
            totalPrice = model.totalPrice
        )
    }

}
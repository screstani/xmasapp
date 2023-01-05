package com.allexandresantos.xmasapp.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allexandresantos.xmasapp.App
import com.allexandresantos.xmasapp.models.OrderModel
import com.allexandresantos.xmasapp.orderrepository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository
) : ViewModel() {

    val orderLiveData = MutableLiveData<OrderModel>()
    private var currentOrder: OrderModel? = null

    fun placeOrder(orderText: String) {
        if (currentOrder != null)
            editOrder()
        else{
            val orderModel = OrderModel(
                orderDetails = orderText,
                orderId = "",
                userId = App.mockUser.userId,
                orderStatus = null,
                products = listOf(),
                totalPrice = calculateOrderPrice(orderText)
            )

            viewModelScope.launch(Dispatchers.IO) {
                val repositoryResponse = orderRepository.placeOrder(orderModel)
                repositoryResponse.fold(
                    onSuccess = {
                        orderLiveData.postValue(it)
                        currentOrder = it
                    },
                    onFailure ={
                        Log.e(TAG, it.message.toString())
                    }
                )
            }
        }

    }

    fun getCurrentOrder() = currentOrder

    private fun editOrder(){
        viewModelScope.launch(Dispatchers.IO) {
            currentOrder?.let { orderModel ->
                val response = orderRepository.editOrder(orderModel)
                response.fold(
                    onSuccess = {
                        orderLiveData.postValue(it)
                        currentOrder = it
                    },
                    onFailure = {
                        Log.e(TAG, it.message.toString())

                    }
                )
            }
        }
    }

    private fun calculateOrderPrice(orderDetails: String): String{
        orderDetails + ""
        return "$12.00"
    }

    companion object{
        val TAG: String = OrderViewModel::class.java.simpleName
    }

}
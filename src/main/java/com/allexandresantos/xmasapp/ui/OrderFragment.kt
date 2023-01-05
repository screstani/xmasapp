package com.allexandresantos.xmasapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.allexandresantos.xmasapp.App
import com.allexandresantos.xmasapp.databinding.FragmentOrderBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class OrderFragment : Fragment() {
    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!
    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        observeViewModel()
    }

    private fun observeViewModel() {
        with(binding) {
            orderViewModel.orderLiveData.observe(viewLifecycleOwner) {
                orderStatus.apply {
                    text = it.orderStatus?.name
                    visibility = View.VISIBLE
                }
                orderIdTextView.text = it.orderId
                orderIdTextView.isVisible = true
                editTextOrder.setText("")
                buttonPlaceOrder.isVisible = false
                buttonEdit.isVisible = true
                buttonPay.isVisible = true
            }
        }
    }

    private fun initViews() {
        with(binding) {
            userName.text = App.mockUser.userName

            buttonPlaceOrder.setOnClickListener {
                orderViewModel.placeOrder(binding.editTextOrder.text.toString())
            }
            buttonEdit.setOnClickListener { btn ->
                orderViewModel.getCurrentOrder().let {
                    orderIdTextView.text = it?.orderId
                    editTextOrder.setText(it?.orderDetails)
                }
                orderStatus.isVisible = false
                btn.isVisible = false
                buttonPay.isVisible = false
                buttonPlaceOrder.isVisible = true
            }

            buttonPay.setOnClickListener {

            }
        }
    }
}
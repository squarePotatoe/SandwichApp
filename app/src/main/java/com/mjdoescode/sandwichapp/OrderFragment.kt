package com.mjdoescode.sandwichapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mjdoescode.sandwichapp.databinding.FragmentOrderBinding
import com.mjdoescode.sandwichapp.model.OrderViewModel

class OrderFragment : Fragment() {
    private var binding: FragmentOrderBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentExtrasBinding = FragmentOrderBinding.inflate(inflater, container, false)
        binding = fragmentExtrasBinding
        return  fragmentExtrasBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            orderFragment = this@OrderFragment
        }

    }

    fun goToNextScreen() {
        findNavController().navigate(R.id.action_extrasFragment_to_summaryFragment)
    }

    fun cancelOrder() {
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_extrasFragment_to_startFragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
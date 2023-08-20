package com.mjdoescode.sandwichapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mjdoescode.sandwichapp.databinding.FragmentStartBinding
import com.mjdoescode.sandwichapp.model.OrderViewModel

class StartFragment : Fragment() {
    private var binding: FragmentStartBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmentStartBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentStartBinding
        return fragmentStartBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.resetOrder()
        binding?.startFragment = this
    }

    fun beginOrder(){
        findNavController().navigate(R.id.action_startFragment_to_extrasFragment)
    }
}
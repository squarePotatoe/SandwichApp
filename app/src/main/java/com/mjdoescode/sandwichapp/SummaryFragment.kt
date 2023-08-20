package com.mjdoescode.sandwichapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.mjdoescode.sandwichapp.databinding.FragmentSummaryBinding
import com.mjdoescode.sandwichapp.model.OrderViewModel

class SummaryFragment : Fragment() {
    private var binding: FragmentSummaryBinding? = null

    private val sharedViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentSummaryBinding = FragmentSummaryBinding.inflate(inflater, container, false)
        binding = fragmentSummaryBinding
        return fragmentSummaryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            summaryFragment = this@SummaryFragment
        }
    }

    fun cancelOrder(){
        sharedViewModel.resetOrder()
        findNavController().navigate(R.id.action_summaryFragment_to_startFragment)
    }

    fun sendOrder() {
        val sandwich = sharedViewModel.sandwich.value!!.name
        val extras = sharedViewModel.showAllExtras()
        val totalPrice = sharedViewModel.subtotal.value

        val intent = Intent(Intent.ACTION_SEND)
            .setType("text/plain")
            .putExtra(Intent.EXTRA_SUBJECT, "New $sandwich order")
            .putExtra(Intent.EXTRA_TEXT, "Extras: \n $extras \n\n Total of: $totalPrice")

        if (activity?.packageManager?.resolveActivity(intent, 0) != null){
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
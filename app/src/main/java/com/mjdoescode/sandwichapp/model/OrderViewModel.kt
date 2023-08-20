package com.mjdoescode.sandwichapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.mjdoescode.sandwichapp.data.DataSource
import java.text.NumberFormat

class OrderViewModel: ViewModel() {

    val menuItems = DataSource.menuItems

    private var previousSandwichPrice = 0.0
    private var previousSidesPrice = 0.0
    private var previousExtrasPrice = 0.0

    private val _sandwich = MutableLiveData<Extra?>()
    val sandwich: LiveData<Extra?> = _sandwich

    private val _side = MutableLiveData<Extra?>()
    val side: LiveData<Extra?> = _side

    private val _subTotal = MutableLiveData<Double>(0.0)
    val subtotal: LiveData<String> = Transformations.map(_subTotal){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _totalPrice = MutableLiveData(0.0)
    val totalPrice: LiveData<String> = Transformations.map(_totalPrice){
        NumberFormat.getCurrencyInstance().format(it)
    }

    private val _selectedExtras = mutableSetOf<Extra?>()
    val selectedExtras: MutableSet<Extra?> = _selectedExtras

    fun setSandwich(chosenSandwich: String){
        if (_sandwich.value != null){
            previousSandwichPrice = _sandwich.value!!.price
        }
        if (_subTotal.value != null){
            _subTotal.value = _subTotal.value!!.minus(previousSandwichPrice)
        }

        _sandwich.value = menuItems[chosenSandwich]
        updatePrice(_sandwich.value!!.price)
    }

    fun addSide(chosenSides: String){
        val selectedSide = menuItems[chosenSides] ?: return

        if (_selectedExtras.contains(selectedSide)){
            _selectedExtras.remove(selectedSide)
            updatePrice(-selectedSide.price)
        } else {
            _selectedExtras.add(selectedSide)
            updatePrice(selectedSide.price)
        }
    }

    private fun updatePrice(price: Double) {
        if (_subTotal.value != null){
            _subTotal.value = _subTotal.value!!.plus(price)
        } else{
            _subTotal.value = price
        }
    }

    fun showAllExtras(): String {
        if (_selectedExtras.isEmpty()){
            return "No extras"
        }

        val extrasList = mutableListOf<String>()

        for (extra in _selectedExtras){
            extrasList.add("${extra!!.name} ${extra.getFormattedPrice()}")
        }

        return extrasList.joinToString("\n")
    }

    fun resetOrder(){
        previousSandwichPrice = 0.0
        _sandwich.value = null
        _side.value = null
        _totalPrice.value = null
        _selectedExtras.clear()
        _subTotal.value = 0.0
    }

}
package com.mjdoescode.sandwichapp.model

import java.text.NumberFormat

data class Extra(
    val name: String,
    val price: Double,
    val itemType: Int
) {
    // Format price to match device location currency
    fun getFormattedPrice(): String = NumberFormat.getCurrencyInstance().format(price)
}

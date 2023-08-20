package com.mjdoescode.sandwichapp.data

import com.mjdoescode.sandwichapp.constants.ItemTypes
import com.mjdoescode.sandwichapp.data.Prices.BEEF_SANDWICH_PRICE
import com.mjdoescode.sandwichapp.data.Prices.CHICKEN_SANDWICH_PRICE
import com.mjdoescode.sandwichapp.data.Prices.CHIPS_PRICE
import com.mjdoescode.sandwichapp.data.Prices.DRINK_PRICE
import com.mjdoescode.sandwichapp.data.Prices.FISH_SANDWICH_PRICE
import com.mjdoescode.sandwichapp.data.Prices.LETTUCE_EXTRA_PRICE
import com.mjdoescode.sandwichapp.data.Prices.PICKLE_EXTRA_PRICE
import com.mjdoescode.sandwichapp.data.Prices.TOMATO_EXTRA_PRICE
import com.mjdoescode.sandwichapp.model.Extra


object DataSource {
    val menuItems = mapOf(
        "beef_sandwich" to Extra(
            name = "Beef Sandwich",
            BEEF_SANDWICH_PRICE,
            itemType = ItemTypes.SANDWICH
        ),
        "chicken_sandwich" to Extra(
            name = "Chicken Sandwich",
            CHICKEN_SANDWICH_PRICE,
            itemType = ItemTypes.SANDWICH
        ),
        "fish_sandwich" to Extra(
            name = "Fish Sandwich",
            FISH_SANDWICH_PRICE,
            itemType = ItemTypes.SANDWICH
        ),
        "drink" to Extra(
            name = "Coffee/Tea refill",
            price = DRINK_PRICE,
            itemType = ItemTypes.SIDES
        ),
        "chips" to Extra(
            name = "Chips",
            price = CHIPS_PRICE,
            itemType = ItemTypes.SIDES
        ),
        "tomato" to Extra(
            name = "Tomato",
            price = TOMATO_EXTRA_PRICE,
            itemType = ItemTypes.EXTRAS
        ),
        "pickles" to Extra(
            name = "Pickles",
            price = PICKLE_EXTRA_PRICE,
            itemType = ItemTypes.EXTRAS
        ),
        "lettuce" to Extra(
            name = "Lettuce",
            price = LETTUCE_EXTRA_PRICE,
            itemType = ItemTypes.EXTRAS
        )
    )
}
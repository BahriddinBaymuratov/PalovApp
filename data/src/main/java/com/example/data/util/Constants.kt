package com.example.data.util

object Constants  {
    const val API_KEY = "72cf9f750aef4b0c98bd29f82c6abafe"
    const val API_KEY2 = "754b79e5a34b441a81e0e83a0e5286c3"
    const val API_KEY3 = "de9f78472d194e7a92d41b1cd39d0582"
    const val BASE_URL = "https://api.spoonacular.com/"
    const val BASE_IMAGE_URL = "https://spoonacular.com/cdn/ingredients_100x100"

    fun dietTypes() = listOf(
        "Gluten Free",
        "Ketogenic",
        "Vegetarian",
        "Lacto-Vegetarian",
        "Vegan",
        "Pescetarian",
        "Paleo",
        "Primal"
    )
    fun mealTypes() = listOf(
        "Main course",
        "Side dish",
        "Dessert",
        "Appetizer",
        "Salad",
        "Breakfast",
        "Soup",
        "Beverage",
        "Sauce",
        "Marinade",
        "Fingerfood",
        "Snack",
        "Drink"
    )
}
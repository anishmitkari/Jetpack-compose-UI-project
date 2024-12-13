package com.anish.jetpackcompose.data

import androidx.annotation.DrawableRes
import com.anish.jetpackcompose.R

data class Pizza(
    @DrawableRes val image:Int,
    val name:String,
    val description:String,
    val price:String
)

val pizzaList = listOf(
    Pizza(
        R.drawable.three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    Pizza(
        R.drawable.three,
        "Peppy Paneer",
        "Chunky paneer with crisp capsicum and spicy red pepper",
        "£16.75"
    ),
    Pizza(
        R.drawable.three,
        "Mexican Green Wave",
        "A pizza loaded with crunchy onions, crisp capsicum, juicy tomatoes",
        "£10.25"
    ),
    Pizza(
        R.drawable.three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    Pizza(
        R.drawable.three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    Pizza(
        R.drawable.three,
        "Peppy Paneer",
        "Chunky paneer with crisp capsicum and spicy red pepper",
        "£19.25"
    ),
    Pizza(
        R.drawable.three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
    Pizza(
        R.drawable.three,
        "Fresh Farm House",
        "crisp capsicum, succulent mushrooms and fresh tomatoes",
        "£14.25"
    ),
)
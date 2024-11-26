package com.example.farmer_room.food

import com.example.farmer_room.R

val mapOfFoods = mapOf(
    R.drawable.pumpkin to "pumpkin",
    R.drawable.carrot to "carrot",
    R.drawable.beetroot to "beetroot",
    R.drawable.tomato to "tomato",
    R.drawable.brinjal to "brinjal",
    R.drawable.pomo to "pomegranate",
    R.drawable.apple to "apple",
    R.drawable.banana to "banana",
    R.drawable.kiwi to "kiwi",
    R.drawable.oranges to "orange"

)

fun filterByFood(type:String):Map<Int,String> {
    return when(type) {
        "veg" ->  mapOfFoods.filter { it.value.split(" ").last() == "veg" }
        "fruit" -> mapOfFoods.filter { it.value.split(" ").last() == "fruit" }
        else -> {
            mapOfFoods}
    }
}

val fm = mapOfFoods.map { Pair(it.value,it.key) }.toMap()
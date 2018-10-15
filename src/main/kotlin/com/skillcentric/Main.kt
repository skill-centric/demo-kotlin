package com.skillcentric

interface Eatable {

    fun consume() = println("Eat me!")
}

interface Drinkable {

    fun consume() = println("Drink me!")
}

class MenuItem : Eatable, Drinkable {

    override fun consume() {

        super<Eatable>.consume()
        super<Drinkable>.consume()

        println("Some custom implementation...")
    }
}

fun main(args: Array<String>) {

    val menuItem = MenuItem()
    menuItem.consume()
}


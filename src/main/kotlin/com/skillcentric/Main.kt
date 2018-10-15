package com.skillcentric

// Variable declarations
// immutable variable
val firstName: String = "Anton"

// type inference
val lastName = "Zaviyalov"

// mutable variable
var age = 30

fun getSecondElement(items: ArrayList<String>) = items[1]

// String template
fun demo(num: Int) {

    val name = if (num % 2 == 0) "Anton" else "Galina"
    println("Hello, $name")
}

fun main(args: Array<String>) {

    val firstName = "Galina"

    println(firstName)

    println(lastName)
}


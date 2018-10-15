package com.skillcentric

// not-null-assertions
fun validateName(name: String?) {

    // if name is null
    // throws KotlinNullPointerException
    val validated = name!!

    println(validated.length)
}

fun main(args: Array<String>) {

    val firstName = "Mike"
    validateName(firstName)

    val lastName = null
    validateName(lastName)
}
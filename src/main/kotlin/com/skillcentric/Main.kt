package com.skillcentric

fun validateInput(name: String?) {

    val validated = name!!

    println(validated.length)
}

fun main(args: Array<String>) {

    val firstName = "Mike"
    validateInput(firstName)

    val lastName = null
    validateInput(lastName)
}





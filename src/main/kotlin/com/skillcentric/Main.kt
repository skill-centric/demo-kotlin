package com.skillcentric

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {

    // Pass a lambda to a library function
    val list = listOf(Person("Alice", 29), Person("Bob", 31))

    // Example 1: how to make syntax shorter
    list.maxBy({ person: Person -> person.age })

    // we can put the lambda outside the parenthesis
    list.maxBy() { person: Person -> person.age }

    // delete empty parenthesis
    list.maxBy { person: Person -> person.age }

    // use type inference
    list.maxBy { person -> person.age }

    // use "it" keyword
    list.maxBy { it.age }

    // Example 2:
    list.joinToString(separator = " ", transform = { person -> person.name })

    // we can put the lambda outside the parenthesis
    list.joinToString(" ") {person -> person.name }

    // Example 3: Assign lambda to a variable
    val sum = { numOne: Int, numTwo: Int -> numOne + numTwo }
    val result = sum(1, 2)
    println(result);

    // Directly call lambda
    { println("Hello world") }()




}


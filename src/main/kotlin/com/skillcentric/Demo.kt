package com.skillcentric

fun main(args: Array<String>) {

    val person = Person(null)

    yellAtSafe(person)
}

// Person comes from java, so it is a platform type
// unsafe call
fun yellAt(person: Person) {

    println(person.name.toUpperCase() + "!!!")
}

// safe call
fun yellAtSafe(person: Person) {

    println((person.name ?: "Anyone").toUpperCase() + "!!!")
}

// You may interpret platform types any way you like
fun demoPlatform() {

    val person = Person("Mike")

    // you may interpret platform type as non-null type
    val name1: String = person.name

    // or you may interpret platform type as nullable type
    val name2: String? = person.name

//    // You can't declare a variable of a platform type
//    // but you can see the platform type info in error messages
//    // String!
//    val name: Int = person.name
}


package com.skillcentric

// Infix call demo
// Note
// 1 to "one"
// is the same as
// 1.to("one")
val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty three")

// "infix" modifier demo
// how "to" function is declared
infix fun Any.to(other: Any) = Pair(this, other)

// Destructuring declaration demo
fun demoDestructuringDeclaration(): Int {

    // Destructuring declaration
    val (number, name) = 1 to "one"

    return number as Int
}

fun main(args: Array<String>) {


}


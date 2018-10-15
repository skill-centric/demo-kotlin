package com.skillcentric

// Class demo (public final is default kotlin visibility)
// this is a "value object"
class Person(
        val name: String,
        var isMarried: Boolean
)

// Custom accessors
//class Rectangle(val width: Int, val height: Int) {
//    val isSquare: Boolean
//        get() {
//            return width == height
//        }
//
//}

class Rectangle(val width: Int, val height: Int) {

    val isSquare: Boolean
        get() = width == height
}

fun main(args: Array<String>) {

    val person = Person("Jake Jameson", true)
    println("The person is ${person.name}. Is married? - ${person.isMarried}")

    val rectangle = Rectangle(10, 10)
    println("Is the rectangle a square? - ${rectangle.isSquare}")
}


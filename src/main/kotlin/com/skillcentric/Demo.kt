package com.skillcentric

fun main(args: Array<String>) {

    demoEquals()

    demoOverloadComparables()
}

// Overloading comparison operators

// Overloading equals()
// a == b first checks if a is not null and then checks a.equals(b)
// equals is not an extension function, is defined in Any class with operator modifier
// all extending classes don't use the operator modifier
// a == b
// a?.equals(b) ?: b == null
// Overload arithmetic operator
data class Point(val x: Int, val y: Int) {

    operator fun plus(other: Point): Point {

        return Point(x + other.x, y + other.y)
    }

    override fun equals(other: Any?): Boolean {

        // identity equals operator
        if (other === this) return true

        if (other !is Point) return false

        return other.x == x && other.y == y
    }
}

fun demoEquals() {

    val point1 = Point(10, 20)
    val point2 = Point(10, 20)

    println("Are equal? - ${point1 == point2}")
}

// Overloading compareTo()
// the operator modifier is applied to the function compareTo() in the base class
// so you don't need to repeat this modifier when overriding the function

// a >= b
// a.compareTo(b) >= 0
class Person(val firstName: String, val lastName: String) : Comparable<Person> {

    override fun compareTo(other: Person): Int {

        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}

fun demoOverloadComparables() {

    val alice = Person("Alice", "Smith")
    val bob = Person("Bob", "Johnson")

    println(alice > bob)
}
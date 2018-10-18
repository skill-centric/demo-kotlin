package com.skillcentric

fun main(args: Array<String>) {

}

// Overload arithmetic operators
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

fun demoOverloadPlus() {

    val pointOne = Point(10, 10)
    val pointTwo = Point(23, 78)

    val summedPoint = pointOne + pointTwo
}

// Alternative: can be declared as an extension function
// Kotlin operator functions: plus, minus, times, div, mod
operator fun Point.minus(other: Point): Point {

    return Point(x - other.x, y - other.y)
}

// You can use different types for the two operands (i.e. Point and Double)
operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

// the return type can also be different
operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

// No bitwise operators in Kotlin
// Instead use infix functions: shl, shr, ushr, and, or, xor, inv
fun demoBitwise() {

    val num = 123
    val numTwo = 456

    val result = num and numTwo
}

// Overloading compound assignment operator
// plusAssign, minusAssign, timesAssign...
operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

fun demoCompuntAssignment() {

    val list = arrayListOf(1, 2, 3)

    // changes the list
    list += 4

    // returns a new list
    val newList = list + listOf(4, 5)
}

// Demo - overloading unary operators
operator fun Point.unaryMinus(): Point {

    return Point(-x, -y)
}

// functions to overload: unaryPlus, unaryMinus, not, inc, dec
// Note: for inc and dec the pre- and post- operators are the same
// (i.e. point++ is the same as ++point)
fun demoUnaryOverload() {

    val point = Point(12, 34)

    val oppositePoint = -point
}












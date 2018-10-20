package com.skillcentric

import java.time.LocalDate

fun main(args: Array<String>) {

    demoIterator()
}

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

// Conventions for collections and ranges
// [] the index operator, the 'in' operator

// Accessing elements by index: get and set
// x[a]
// x.get(a)
// or with multiple indeces
// x[a, b]
// x.get(a, b)
operator fun Point.get(index: Int): Int {

    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun demoIndexOperator() {

    val point = Point(10, 20)

    println(point[0])
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.get(index: Int): Int {

    return when (index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

// x[a] = b
// x.set(a, b)
operator fun MutablePoint.set(index: Int, value: Int) {

    when (index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun demoSetMethod() {
    val point = MutablePoint(10, 20)
    point[0] = 30
    println(point[0])
}

// Demo 'in' convention
// .contains() function
// a in b
// b.contains(a)
data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(point: Point): Boolean {

    return point.x in upperLeft.x until lowerRight.x &&
            point.y in upperLeft.y until lowerRight.y
}

fun demoContainsFunction() {

    val rect = Rectangle(Point(10, 20), Point(50, 50))

    println(Point(20, 30) in rect)
}

// Demo 'rangeTo' convention
// 1..100
// start..end
// start.rangeTo(end)

fun demoRangeTo() {

    val now = LocalDate.now()
    val vacation = now..now.plusDays(10)

    println(now.plusWeeks(1) in vacation)

}

// The iterator convention
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =

        object : Iterator<LocalDate> {

            var current = start

            override fun hasNext(): Boolean =
                    current <= endInclusive

            override fun next(): LocalDate =
                    current.apply { current = plusDays(1) }


        }

fun demoIterator() {

    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear

    for (dayOff in daysOff) {
        println(dayOff)
    }
}


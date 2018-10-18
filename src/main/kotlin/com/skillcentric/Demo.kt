package com.skillcentric

import java.lang.IllegalStateException

fun main(args: Array<String>) {

}

// Kotlin doesn't differentiate between primitives and wrappers (int VS Integer)

// Int? is stored and Integer
// Int is stored as int (but for generic types as Integer)
data class Person(val name: String, val age: Int? = null) {

    fun isOlderThan(other: Person): Boolean? {

        if (age == null || other.age == null) {
            return null
        } else {
            return age > other.age
        }
    }
}

// conversion demo
fun demoConversion() {

    val intNum: Int = 123

//    // no conversion -> won't compile
//    val longNum: Long = intNum

    val longNum: Long = intNum.toLong()
    val anotherIntNum = longNum.toInt()
}

// demo Any
// Any corresponds to java.lang.Object
// Any is a supertype of all types, including primitives (Int, Double...)
val answer: Any = 42

// demo Unit
fun demoUnit(): Unit {
    println("Hello")
}

// But unlike 'void' Unit is a full-fledged type
interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {

    override fun process() {
        // some implementation...
    }
}

// demo Nothing
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

// Precondition checking with elvis operator
val address = "some validatedAddress"
val validatedAddress = address ?: fail("No address")


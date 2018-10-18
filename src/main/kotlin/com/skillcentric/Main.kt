package com.skillcentric

fun main(args: Array<String>) {

    args.forEachIndexed { index, element -> println("$index -> $element") }
}

fun demoArrays() {

    // demo - create an array using a constructor
    val letters = Array(26) { i -> ('a' + i).toString() }

    for (letter in letters) {
        println(letter)
    }

    // demo - use arrayOf
    val nums = arrayOf(1, 2, 3)

    // demo - use arrayOfNulls
    val nulls: Array<Any?> = arrayOfNulls(size = 10)

    // demo - call .toTypedArray()
    val list = listOf("Mike", "Jack", "Tom")
    val names = list.toTypedArray()
}

// Type parameters of arrays:
// Array<Int> -> java.lang.Integer[]
// IntArray -> int[]
fun demoTypeParams() {

    val arrayOfBoxedIntegers = Array<Int>(10) { it + 10 }

    val arrayOfPrimitiveIntegers = IntArray(10) { it + 10 }

    // conversion
    val nums = arrayOfBoxedIntegers.toIntArray()
}


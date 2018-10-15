package com.skillcentric

// top-level function declaration
// the same as java: MainKt.java -> public static String greet() {...}
// how to call from java: MainKt.hello();
fun greet(): String {
    return "Hello world"
}

fun sayHello() {
    println("Hello!")
}

// block body
fun max(num1: Int, num2: Int): Int {

    return if (num1 >= num2) num1 else num2
}

// expression body
// return type is omitted (thanks to type inference)
fun min(valueOne: Int, valueTwo: Int) = if (valueOne < valueTwo) valueOne else valueTwo

fun main(args: Array<String>) {

    sayHello()

    val maxNum = max(12, 34)

    println("The max num is $maxNum")
}


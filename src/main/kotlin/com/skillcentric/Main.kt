package com.skillcentric

// Varargs demo
// How to call in kotlin: val result = demoList("some", *someArray)
// * is a "spread operator", it unpacks the array elements
fun demoList(vararg values: String): String {
    val result = StringBuilder()
    for (value in values) {
        result.append(value)
        result.append(" ")
    }
    return result.toString()
}

fun main(args: Array<String>) {


}


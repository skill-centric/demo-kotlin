package com.skillcentric

// How to access in java: MainKt.topLevelFunction()
fun topLevelFunction() {
    println("I am top level function")
}

// top-level immutable property
// The same as MainKt.java -> private String lineSeparator; + getLineSeparator(){...}
val lineSeparator = "\n"

// top-level mutable property
// The same as MainKt.java -> private int count; + getCount(){...} + setCount(...){...}
// How to access in java: MainKt.getCount();
// How to access in java: MainKt.setCount(123);
var count = 0

// top-level constant
// the same as: public static final String ANOTHER_LINE_SEPARATOR
// How to access in java: MainKt.ANOTHER_LINE_SEPARATOR
const val ANOTHER_LINE_SEPARATOR = "\n"

fun main(args: Array<String>) {

    topLevelFunction()
}


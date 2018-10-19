package com.skillcentric

fun main(args: Array<String>) {

    demoPrintEntries()
}

// Demo destructuring declaration
// unpack a single composite value and store it in several separate variables
class Point(val x: Int, val y: Int){

    // this functions are final and default in a data class
    operator fun component1() = x
    operator fun component2() = y
}

fun demoDest() {

    val point = Point(10, 20)
    val (x, y) = point
    println("X is $x, y is $y")
}

// Under the hood convention is used
// val (a, b) = p
// val a = p.component1()
// val b = p.component2()
// Destructuring declarations are transformed into componentN function calls
// An alternative: Pair() and Triple() classes

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents {

//    val result = fullName.split(".", limit = 2)
//
//    return NameComponents(result[0], result[1])

    val (name, extension) = fullName.split(".", limit = 2)
    return NameComponents(name, extension)

}

fun demoNameComponents() {

    val (name, extension) = splitFilename("example.kt")
    println("Name: $name, extension: $extension")
}

// Destructuring declarations in loops
fun printEntries(map: Map<String, String>){

    for((key, value) in map){
        println("$key -> $value")
    }

//    // the same as
//    for (entry in map.entries) {
//
//        val key = entry.key
//        val value = entry.value
//        println("$key -> $value")
//    }
}

fun demoPrintEntries() {

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}


package com.skillcentric

// Named arguments
// Example: val result = joinToString(someCollection, separator = " -> ", prefix = "{", postfix = "}")
fun <T> joinToString(collection: Collection<T>,
                     separator: String,
                     prefix: String,
                     postfix: String): String {

    val result = StringBuilder()

    result.append(prefix)

    for ((index, element) in collection.withIndex()) {

        if (index > 0)
            result.append(separator)

        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

// Default parameter values
fun <T> joinToStringTwo(collection: Collection<T>,
                        separator: String = ", ",
                        prefix: String = "[",
                        postfix: String = "]"): String {

    val result = StringBuilder()
    result.append(prefix)

    for ((index, element) in collection.withIndex()) {

        if (index > 0)
            result.append(separator)

        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

fun main(args: Array<String>) {

    val names = setOf("Anton", "Galina", "Jack", "Mike")
    println(joinToStringTwo(names))
}


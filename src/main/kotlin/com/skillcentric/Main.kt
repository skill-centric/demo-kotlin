package com.skillcentric

fun main(args: Array<String>) {


}

fun capitalize(input: String) = input.toUpperCase()

fun demoCapitalize() {

    // passing null value isn't allowed by the compiler
    capitalize(null)
}

// Nullable type: String? = String + null
fun demo(input: String?) {

    // not allowed (can use only ?. or !!. calls)
    input.toUpperCase()

    // not allowed (type mismatch)
    val someString: String = input

    // not allowed (type mismatch)
    capitalize(input)

    // you can compare with null
    // Note: if checks are too verbose
    if (input != null) {

        // now these are allowed
        input.length
        val someString: String = input
        capitalize(input)
    }
}
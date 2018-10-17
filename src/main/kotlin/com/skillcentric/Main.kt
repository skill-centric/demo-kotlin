package com.skillcentric

fun main(args: Array<String>) {

}

// Extensions on nullable types
fun String?.myIsNullOrBlank(): Boolean =
        this == null || this.isBlank()

// Extension functions on nullable types can be called without safe call
fun demoNullTypesExtension() {

    val firstName: String? = "Galina"

    // no safe call is needed
    val result = firstName.myIsNullOrBlank()
}














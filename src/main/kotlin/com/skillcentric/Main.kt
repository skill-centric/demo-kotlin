package com.skillcentric

fun main(args: Array<String>) {


}

// Nullability of type parameters
// by default type parameters are nullable
fun <T> printHashCode(t: T) {

    // need safe case
    println(t?.hashCode())
}

// to make the type parameter non-null use upper bound
fun <T : Any> printHashCodeTwo(t: T) {

    // needs no safe cast
    println(t.hashCode())
}
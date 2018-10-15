package com.skillcentric

// Elvis operator
// or null coalescing operator
fun foo(s: String?) = s ?: "no"

// Can be used together with safe call
fun strLenSafe(s: String?) = s?.length ?: 0

// Chaining
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

// "throw" is and expression, so it can be used with elvis operator
fun printShippingLabel(person: Person) {

    val address = person.company?.address ?: throw IllegalArgumentException("Address must be non-null")

    with(address) {

        println(streetAddress)
        println("$zipCode $city $country")
    }
}
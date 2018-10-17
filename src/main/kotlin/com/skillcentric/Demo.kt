package com.skillcentric

// Safe call operator ?.
fun demoSafeCallOperator() {

    val name: String? = "Galina"

    // The same as if(... != null) ... else null
    val result = name?.length

    val resultTwo = if (name != null)
        name.length
    else
        null
}

// Note safe call return mutable types
fun printAllCaps(s: String?) {

    val allCaps: String? = s?.toUpperCase()

    // allCaps is either String or null
    println(allCaps)
}

// Safe calls can be used to access properties as well
class Employee(val name: String, val manager: Employee?)

fun managerName(empl: Employee): String? {

    return empl.manager?.name
}

// Chaining
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {

    // this is chaining of safe calls
    val country = this.company?.address?.country

    // elvis operator
    return country ?: "no"
}





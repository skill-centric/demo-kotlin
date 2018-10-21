package com.skillcentric

fun main(args: Array<String>) {

    demoAverageDurationForCondition()
}

// Lambdas as parameters and return values
// Higher order functions take other functions as params or return them

// Function types
// Explicit type declaration
val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
val action: () -> Unit = { print(43) }

// the return type can be nullable
var canReturnNull: (Int, Int) -> Int? = { _, _ -> null }

// function type can be nullable
var funOrNull: ((Int, Int) -> Int)? = null

// parameter names of function types
fun performRequest(url: String, callback: (code: Int, content: String) -> Unit) {

    // some logic...
    callback(200, "OK")
}

fun twoAndThree(operation: (Int, Int) -> Int) {

    val result = operation(2, 3)
    println("The result is $result")
}

fun demoTwoAndThree() {

    val sum = { x: Int, y: Int -> x + y }
    twoAndThree(sum)

    val multiplication = { x: Int, y: Int -> x * y }
    twoAndThree(multiplication)
}

// Implement filter() function
fun String.filter(predicate: (Char) -> Boolean): String {

    val builder = StringBuilder()

    for (index in 0 until length) {

        val element = get(index)

        if (predicate(element))
            builder.append(element)
    }

    return builder.toString()
}

fun stringFilterDemo() {

    val input = "ab78024c42asdfz"

    val validated = input.filter { it in 'a'..'z' }

    println("Validated string: $validated")
}

// Using function types from java (see the Client.java)
fun processTheAnswer(someFunction: (Int) -> Int) {

    println(someFunction(42))
}

// Default and null values for parameters with function types
fun <T> Collection<T>.myJoinToString(separator: String = ", ",
                                     prefix: String = "",
                                     postfix: String = "",
                                     transform: (T) -> String = { it.toString() }): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {

        if (index > 0)
            result.append(separator)

        // Calling the parameter function
        // The default function is .toString()
        result.append(transform(element))
    }

    result.append(postfix)

    return result.toString()
}

fun demoJoinToString() {

    val letters = listOf("Alpha", "Beta")

    println(letters.myJoinToString())

    println(letters.myJoinToString { it.toLowerCase() })

    println(letters.myJoinToString(prefix = "{", postfix = "}") { it.toUpperCase() })

    println(letters.myJoinToString(prefix = "{", postfix = "}", transform = { it.toLowerCase() }))

}

// Nullable functions as function parameter
fun foo(callback: (() -> Unit)?) {

    // (1) smart cast
    if (callback != null) {

        callback()
    }

    // (2) use safe call
    callback?.invoke()
}

// Nullable parameter function demo
fun <T> Collection<T>.mySecondJoinToString(separator: String = ", ",
                                           prefix: String = "",
                                           postfix: String = "",
                                           transform: ((T) -> String)? = null): String {

    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {

        if (index > 0)
            result.append(separator)

        // Calling the nullable parameter function
        // Using the safe call and the elvis operator
        val str = transform?.invoke(element) ?: element.toString()

        result.append(str)
    }

    result.append(postfix)

    return result.toString()
}

// Returning functions from functions
enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {

    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }

    return { order -> 1.2 * order.itemCount }
}

fun demoCalculator() {

    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)

    println(calculator(Order(3)))
}


data class Person(val firstName: String, val lastName: String, val phoneNumber: String?)

// Functions as return type
class ContactListFilters {

    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {

        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix
        }

        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun demoContactsList() {

    val contacts = listOf(Person("Mike", "Johnson", "123-456"),
            Person("Nick", "Nickson", null))

    val filter = ContactListFilters()

    with(filter) {

        prefix = "Mi"
        onlyWithPhoneNumber = true
    }

    println(contacts.filter(filter.getPredicate()))
}

// Removing duplication through lambdas
// Function types - lambda and method references

enum class OS {
    WINDOWS, LINUX, MAC, IOS, ANDROID
}

data class SiteVisit(val path: String, val duration: Double, val os: OS)

// the list of data
val log = listOf(SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
)

fun demoDuplication() {

    val averageWindowsDuration = log.asSequence()
            .filter { it.os == OS.WINDOWS }
            .map(SiteVisit::duration)
            .average()

    println("Average windows duration: $averageWindowsDuration")
}

// Declare an extension function to remove code duplication
fun List<SiteVisit>.averageDurationFor(os: OS) =
        asSequence()
                .filter { it.os == os }
                .map(SiteVisit::duration)
                .average()

// demo use of the extension function
fun demoAverageDuration() {

    println("Average Mac duration: ${log.averageDurationFor(OS.MAC)}")
    println("Average Android duration: ${log.averageDurationFor(OS.ANDROID)}")
    println("Average IOS duration: ${log.averageDurationFor(OS.IOS)}")
}

fun demoAvarageMobileDuration() {

    val avarageMobileDuration = log.asSequence()
            .filter { it.os in setOf(OS.ANDROID, OS.IOS) }
            .map(SiteVisit::duration)
            .average()
}

fun List<SiteVisit>.averageDurationForCondition(predicate: (SiteVisit) -> Boolean) =
        asSequence().filter(predicate)
                .map(SiteVisit::duration)
                .average()

fun demoAverageDurationForCondition() {

    println(log.averageDurationForCondition { it.os in setOf(OS.ANDROID, OS.IOS) })

    println(log.averageDurationForCondition { it.os == OS.IOS && it.path == "/signup"})
}










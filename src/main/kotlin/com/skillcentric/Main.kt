package com.skillcentric

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {

    // Pass a lambda to a library function
    val list = listOf(Person("Alice", 29), Person("Bob", 31))

    // Example 1: how to make syntax shorter
    list.maxBy({ person: Person -> person.age })

    // we can put the lambda outside the parenthesis
    list.maxBy() { person: Person -> person.age }

    // delete empty parenthesis
    list.maxBy { person: Person -> person.age }

    // use type inference
    list.maxBy { person -> person.age }

    // use "it" keyword
    list.maxBy { it.age }

    // Example 2:
    list.joinToString(separator = " ", transform = { person -> person.name })

    // we can put the lambda outside the parenthesis
    list.joinToString(" ") { person -> person.name }

    // Example 3: Assign lambda to a variable
    val sum = { numOne: Int, numTwo: Int -> numOne + numTwo }
    val result = sum(1, 2)
    println(result);

    // Directly call lambda
    { println("Hello world") }()

    val messages = listOf("Hello", "World")
    printMessagesWithPrefix(messages, prefix = "-")

    val count = tryToCountButtonClicks(Button())
    println(count)
}

// lambdas "capture" function parameters and local variables
fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {

    messages.forEach {
        println("$prefix $it")
    }
}

// In contrast to java, kotlin lambdas
// can access non-final variables from outer scope and change their values
fun printProblemCounts(responses: Collection<String>) {

    var clientProblems = 0
    var serverProblems = 0

    responses.forEach {

        if (it.startsWith("4"))
            clientProblems++
        else if (it.startsWith("5"))
            serverProblems++
    }

    println("Client problems: $clientProblems, server problems: $serverProblems")
}

class Button {

    fun click(clickAction: () -> Unit) {

    }
}

// Note: it will always return 0
// because the lambda is executed after the function returns
fun tryToCountButtonClicks(button: Button): Int {

    var count = 0
    button.click { count++ }

    return count
}





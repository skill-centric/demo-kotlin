package com.skillcentric

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {

    // Directly call lambda
    { println("Hello world") }()

    // Variable capturing demo
    val messages = listOf("Hello", "World")
    printMessagesWithPrefix(messages, prefix = "-")

    val count = tryToCountButtonClicks(Button())
    println(count)
}

fun demoLambdaSyntax() {

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
}

fun demoPutOutsideParenthesis() {

    // Pass a lambda to a library function
    val list = listOf(Person("Alice", 29), Person("Bob", 31))

    // Example 2:
    list.joinToString(separator = " ", transform = { person -> person.name })

    // we can put the lambda outside the parenthesis
    list.joinToString(" ") { person -> person.name }
}

//  Assign lambda to a variable
fun demoAssignToVariable() {

    val sum = { numOne: Int, numTwo: Int -> numOne + numTwo }
    val result = sum(1, 2)
    println(result);
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

    fun click(action: () -> Unit) {

    }
}

// Note: it will always return 0
// because the lambda is executed after the function returns
fun tryToCountButtonClicks(button: Button): Int {

    var count = 0
    button.click { count++ }

    return count
}

// Member reference demo
// The same as: val getAge = { person: Person -> person.age }
val getAge = Person::age

// top-level function demo
fun sendEmail(person: Person, message: String) {
    // some implementation...
}

val action = { person: Person, message: String -> sendEmail(person, message) }
val sameAction = ::sendEmail

// constructor reference
val createPerson = ::Person
val person = createPerson("Alice", 29)

// extension function demo
fun Person.isAdult() = age > 21

// refer to the extension function
val predicate = Person::isAdult

// how to call
fun demoCall() {
    val person = Person("Mike", 23)
    val isAdult: Boolean = predicate(person)
}

// A bound member reference demo
fun demoBoundMemberReference() {

    val mikeAgeFunction = person::age
    println(mikeAgeFunction())
}

// Functional APIs for collections
fun demoFilter() {

    val list = listOf(1, 2, 3, 4)
    list.filter { it % 2 == 0 }

    val people = listOf(Person("Alice", 29),
            Person("Mike", 38),
            Person("Jack", 35))

    people.filter { it.age > 30 }
}

fun demoMap() {

    val list = listOf(1, 2, 3, 4)
    list.map { it * it }

    val people = listOf(Person("Alice", 29),
            Person("Mike", 38),
            Person("Jack", 35))

    val names = people.map { it.name }
    val sameNames = people.map(Person::name)
}

// Chaining
fun demoChaining() {

    val people = listOf(Person("Alice", 29),
            Person("Mike", 38),
            Person("Jack", 35))

    val names = people.filter { it.age > 30 }
            .map(Person::name)
}

fun moreDemo() {

    // find the people with the same age, which is the max age in the group
    val people = listOf(Person("Alice", 29),
            Person("Mike", 38),
            Person("Jack", 35),
            Person("Jane", 38))

    val maxAge = people.maxBy(Person::age)?.age
    people.filter { it.age == maxAge }
}

fun demoMaps() {

    val numbers = mapOf(0 to "zero", 1 to "one")

    numbers.mapValues { it.value.toUpperCase() }
}

fun demoAllAnyCountFind() {

    val canBeInClub27 = { p: Person -> p.age < 27 }
    val people = listOf(Person("Alice", 25),
            Person("Mike", 38),
            Person("Jack", 35),
            Person("Jane", 38))

    people.all(canBeInClub27)
    people.any(canBeInClub27)
    people.count(canBeInClub27)
    people.find(canBeInClub27)
}

// Lazy collection operations
// functions create intermediate collections eagerly, meaning the
// intermediate result of each step is stored in a temporary list. Sequences give you an
// alternative way to perform such computations that avoids the creation of intermediate
// temporary objects.
fun demoLazy() {

    val people = listOf(Person("Alice", 25),
            Person("Mike", 38),
            Person("Jack", 35),
            Person("Jane", 38))

    // Intermediate collections are created
    people.map(Person::name).filter { it.startsWith("J") }

    // Intermediate collections are not created
    people.asSequence().map(Person::name).filter { it.startsWith("J") }
}

// Using Java functional interfaces (SAM interfaces)
// SAM - single abstract method
fun demoSamMethods() {

    val actor = Actor()

    // Note: object expression is used here instead of anonymous class
    // a new instance of this object will be created on each method call
    actor.processDoable(object : Doable {
        override fun doJob(description: String?): String {

            return "my $description"
        }
    })

    // Note: lambda is used here
    // if the lambda doesn’t access any variables from the function where it’s defined,
    // the corresponding anonymous class instance is reused between calls
    actor.processDoable { description -> "my $description" }

    // the same as:
    actor.processDoable(theAction)

    // If the lambda captures variables from the surrounding scope, it’s no longer possible to
    // reuse the same instance for every invocation.
    // In that case, the compiler creates a new object for every call
    // and stores the values of the captured variables in that object.
    actor.processDoableWithCapturing("Important") { description -> "my $description" }

}

// (object is reused)
val theAction = { description: String -> "my $description" }

// SAM constructors: explicit conversion of lambdas to functional interfaces
// (1) when method return an instance of functional interface, you can't return a lambda directly
// you need to call SAM constructor
fun createAllDoneRunnable(): Runnable {

    return Runnable { println("All done!") }
}

// (2) when you need to store the functional interface instance into a variable
// Android demo
//fun demoSamConstructor() {
//
//    val listener = OnClickListener { view ->
//
//        val text = when (view.id) {
//            R.id.button1 -> "First button"
//            R.id.button2 -> "Second button"
//            else -> "Unknown button"
//        }
//        toast(text)
//    }
//
//    button.setOnClickListener(listener)
//}

// Lambda vs object expression
// Note that there’s no this in a lambda as there is in an anonymous object:
// there’s no way to refer to the anonymous class instance into which the
// lambda is converted. From the compiler’s point of view, the lambda is a
// block of code, not an object, and you can’t refer to it as an object. The
// this reference in a lambda refers to a surrounding class.
// If your event listener needs to unsubscribe itself while handling an event,
// you can’t use a lambda for that. Use an anonymous object to implement
// a listener, instead. In an anonymous object, the this keyword refers to
// the instance of that object, and you can pass it to the API that removes
// the listener.



















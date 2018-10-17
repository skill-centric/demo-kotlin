package com.skillcentric

fun main(args: Array<String>) {

    println(demoIfElse())

    println(demoSafeCast())
}

fun demoRegularCastAndSmartCast() {

    val num: Number = 123

    // Regular cast
    val integerOne: Int = num as Int

    // Smart cast
    if(num is Int){
        val integerTwo: Int = num
    }
}

fun demoClassCastException() {

    val num: Any = 123

    // ClassCastException is thrown at runtime
    val result: String = num as String
}

fun demoIfElse(): String? {

    val num: Any = 123

    // if the num is String, then result is assign num as String
    // if the num is not String, then result is assigned null
    // ClassCastException is prevented at runtime
    val result = if (num is String) {
        num as String
    } else {
        null
    }

    return result
}

fun demoSafeCast(): String? {

    val num: Any = 123

    // if the num is String, then result is assign num as String
    // if the num is not String, then result is assigned null
    // ClassCastException is prevented at runtime
    val result = num as? String

    return result
}

// safe cast can be used with elvis operator
class Professor(val firstName: String, val lastName: String){

    override fun equals(other: Any?): Boolean {

        val otherStudent = other as? Professor ?: return false

        return this.firstName == otherStudent.firstName && this.lastName == otherStudent.lastName
    }

    override fun hashCode(): Int {
        return firstName.hashCode() + 31 * lastName.hashCode()
    }
}
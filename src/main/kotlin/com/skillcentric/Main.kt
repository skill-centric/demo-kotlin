package com.skillcentric

fun main(args: Array<String>) {

    println(safeCastDemo())
}

fun regularCastAndSmartCast() {

    val num: Number = 123

    val resultOne: Int = num as Int

    if (num is Int) {
        val resultTwo: Int = num
    }
}

fun classCastExceptionDemo() {

    val num: Any = 123

    val result: String? = if (num is String) {
        num as String
    } else {
        null
    }
}

fun safeCastDemo(): String? {

    val num: Any = 123

    val result = num as? String

    return result

}

class Student(val firstName: String, val lastName: String){

    override fun equals(other: Any?): Boolean {

        val otherStudent = other as? Student ?: return false

        return firstName == otherStudent.firstName && lastName == otherStudent.lastName

    }

    override fun hashCode(): Int {
        return firstName.hashCode() + 31 * lastName.hashCode()
    }
}










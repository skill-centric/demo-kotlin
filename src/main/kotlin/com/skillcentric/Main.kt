package com.skillcentric

fun main(args: Array<String>) {

    val firstName: String? = "Mike"

    val numOfLetters = if (firstName != null) {
        firstName.count()
    } else {
        null
    }

    val numOfLettersTwo = firstName?.count()

    val numOfLettersThree = firstName?.length

    val minor = Minor("CS", null)

    val student = Student("Mike", minor)

    println("Student minor info capitalised: ${student.minor?.info?.toUpperCase()}")
}

class Minor(val title: String, val info: String?)

class Student(val name: String, val minor: Minor?)

















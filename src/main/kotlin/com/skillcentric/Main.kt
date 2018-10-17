package com.skillcentric

fun main(args: Array<String>) {

}

class Student(val name: String)

class SomeActivity {

    private var student: Student? = null

    fun onCreate(){

        student = Student("Mike")
    }

    fun onResume(){

        val nameOne = student!!.name

        val nameTwo = student?.name
    }
}

class AnotherActivity {

    private lateinit var student: Student

    fun onCreate() {

        student = Student("Mike")
    }

    fun onResume() {

        val name = student.name
    }
}
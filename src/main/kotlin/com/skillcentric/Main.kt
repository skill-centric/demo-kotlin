package com.skillcentric

fun main(args: Array<String>) {

    val student = Student(null)

    getNameLengthSafe(student)
}

fun getNameLength(student: Student) {

    println(student.lastName.count())
}

fun getNameLengthSafe(student: Student) {

    println(student.lastName?.count() ?: "0")
}

fun demoPlatformType() {

    val student = Student("Mike")

    val nameOne: String = student.lastName

    val nameTwo: String?  = student.lastName

//    val nameThree: Int = student.lastName

}





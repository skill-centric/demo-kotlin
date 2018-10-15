package com.skillcentric

fun main(args: Array<String>) {


}

fun processName(name: String?): String {

    val processedName =  if (name != null) {
        name
    } else {
        "empty"
    }

    val resultTwo = name ?: "empty"

    return resultTwo
}

fun stringLength(input: String?) = input?.length ?: 0

fun validateInput(input: String?) = input ?: throw IllegalStateException("Input must not be null")




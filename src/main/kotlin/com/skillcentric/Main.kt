package com.skillcentric

// enum demo
enum class DayOfWeek {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

// enum declaration
enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    YELLOW(255, 255, 0),
    ORANGE(255, 165, 0),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

// when demo
//fun getMnemonic(color: Color): String {
//
//    return when(color){
//
//        Color.RED -> "Red"
//        Color.GREEN -> "Green"
//        Color.BLUE -> "Blue"
//    }
//}

fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Red"
            Color.GREEN -> "Green"
            Color.BLUE -> "Blue"
            else -> "other"
        }

//fun getWarmth(color: Color): String {
//
//    return when(color) {
//        Color.RED, Color.GREEN -> "warm or neutral"
//        Color.BLUE -> "cold"
//    }
//
//}

fun getWarmth(color: Color) =
        when (color) {
            Color.RED, Color.GREEN -> "warm or neutral"
            Color.BLUE -> "cold"
            else -> "other"
        }

// when arguments are not only constants
fun mix(color1: Color, color2: Color) =
        when (setOf(color1, color2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

// when with no argument
fun mixOptimized(color1: Color, color2: Color) =
        when {
            (color1 == Color.RED && color2 == Color.YELLOW) -> Color.ORANGE
            (color1 == Color.YELLOW && color2 == Color.BLUE) -> Color.GREEN
            (color1 == Color.BLUE && color2 == Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

interface Expr

class Num(val value: Int) : Expr

class Sum(val left: Expr, val right: Expr) : Expr

//fun eval(e: Expr): Int {
//
//    return if (e is Num) {
//        e.value
//    } else if (e is Sum) {
//        eval(e.right) + eval(e.left)
//    } else {
//        throw IllegalArgumentException()
//    }
//}

fun eval(e: Expr): Int =
        if (e is Num) {
            e.value
        } else if (e is Sum) {
            eval(e.right) + eval(e.left)
        } else {
            throw IllegalArgumentException()
        }

fun evalKotlinized(e: Expr) =
        when (e) {
            is Num -> e.value
            is Sum -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException()
        }

fun fizzbuzz(num: Int) =
        when {
            (num % 15 == 0) -> "Fizzbuzz "
            (num % 5 == 0) -> "Fizz "
            (num % 3 == 0) -> "Buzz "
            else -> "$num "
        }

fun checkFirstHundred(): String {

    val builder = StringBuilder();

    for (i in 1..100) {

        builder.append(fizzbuzz(i))
    }

    return builder.toString()
}

fun main(args: Array<String>) {

    println(checkFirstHundred())
}


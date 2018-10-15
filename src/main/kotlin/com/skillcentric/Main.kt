package com.skillcentric

// Sealed classes
sealed class Expression {
    class Num(val value: Int) : Expression()
    class Sum(val left: Expression, val right: Expression) : Expression()
}

// Because we are using a sealed class
// no "else" is required in the when clause
fun evaluate(expression: Expression): Int =
        when (expression) {
            is Expression.Num -> expression.value
            is Expression.Sum -> evaluate(expression.right) + evaluate(expression.left)
        }

fun main(args: Array<String>) {


}


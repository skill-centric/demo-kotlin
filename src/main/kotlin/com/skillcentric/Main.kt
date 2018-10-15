package com.skillcentric

// extension function demo
// String is a "receiver type"
// this is a "receiver object"
// The same as MainKt.java -> public static char lastCharacter(String thisString) {...}
fun String.lastCharacter(): Char = this[this.length - 1]

// Extension function
// How to call in java: MainKt.myJoinToString(someCollection, ", ", "[", "]");
fun <T> Collection<T>.myJoinToString(separator: String = ", ",
                                     prefix: String = "",
                                     postfix: String = ""): String {

    val result = StringBuilder()
    result.append(prefix)

    for ((index, element) in this.withIndex()) {

        if (index > 0)
            result.append(separator)

        result.append(element)
    }

    result.append(postfix)

    return result.toString()
}

// Note: extension functions cannot be overriden
open class View {
    open fun click() = "View is clicked"
}

open class Button : View() {
    override fun click() = "Button is clicked"
}

fun View.showOff() = "View is shown"
fun Button.showOff() = "Button is shown"

fun demoExtensionFunctionNotOverriden() {

    val view: View = Button()

    // returns Button is clicked
    // i.e. dynamic binding
    view.click()

    // returns View is shown
    // i.e. static binding
    view.showOff()
}

// Extension properties
val String.lastChar: Char
    get() = get(length - 1)

// how to call in kotlin: someStringBuilder.lastChar
// how to call in kotlin: someStringBuilder.lastChar = 'C'
// how to call in java: MainKt.getLastChar(someStringBuilder);
// how to call in java: MainKt.setLastChar(someStringBuilder, 'C');
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

fun main(args: Array<String>) {


}


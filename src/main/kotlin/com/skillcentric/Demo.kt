package com.skillcentric

// Interface demo
interface Clickable {
    fun click()

    // default method demo
    fun showOff() = println("I am clickable!")
}

// Implementing an interface and overriding an abstract method
class CustomButton : Clickable {

    override fun click() = println("I was clicked")
}

interface Focusable {

    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus")

    fun showOff() = println("I am focusable")
}

// Demo: conflicting methods in implemented interfaces
// Calling a super method from the implementing class
class CustomView : Clickable, Focusable {
    override fun click() = println("CustomView is clicked")

    // CustomView inherits many implementations of showOff
    // Therefore must override this method explicitly
    override fun showOff() {

        // NOTE: parent method call
        // in java: Clickable.super.showOff();
        super<Clickable>.showOff()
        super<Focusable>.showOff()

        println("I am CustomView instance!")
    }
}
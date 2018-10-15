package com.skillcentric

// Interface demo
interface Clickable {

    fun click()

    // default method demo
    fun showOff() = println("I am clickable!")
}

// Inheritance modifiers: final, open, abstract, override
// open and final modifiers demo
open class RichButton : Clickable {

    // public final by default
    fun disable() {
    }

    // public open for overriding in subclasses
    open fun animate() {
    }

    // open for overriding in subclasses
    override fun click() {
    }

//    // closed for overriding in subclasses
//    final override fun click() {
//
//    }
}


// abstract modifier demo
abstract class Animated {

    // open by default -> must be overriden in subclass
    abstract fun animate()

    // can be overriden in subclass
    open fun stopAnimating() {
    }

    // final by default
    // cannot be overriden in subclass
    fun animateTwice() {
    }
}

fun main(args: Array<String>) {

    val button = RichButton()

    button.disable()
}


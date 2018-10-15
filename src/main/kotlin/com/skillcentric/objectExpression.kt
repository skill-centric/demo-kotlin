package com.skillcentric

// Object expression
// Used for replacing anonymous inner classes

class Button {

    private val listeners = ArrayList<OnClickListener>()

    fun addOnClickListener(listener: OnClickListener) {

        listeners.add(listener)
    }

    fun click() {

        for (listener in listeners) {
            listener.onClick(Event("Client Screen"))
        }
    }
}

interface OnClickListener {

    fun onClick(event: Event)
}

class Event(val source: String)

fun demoClicks(button: Button) {

    // Note: can be not final in kotlin
    var buttonClick = 0

    button.addOnClickListener(object: OnClickListener{

        override fun onClick(event: Event) {

            // not possible in java:
            // java can access only final outer variables
            buttonClick++
        }
    })
}

fun main(args: Array<String>) {

    val button = Button()

    // Note: object expression is used instead of anonymous inner class
    button.addOnClickListener(object : OnClickListener {

        override fun onClick(event: Event) {
            println("The source: ${event.source}")
        }
    })

    // Expression object can be assigned to a variable
    var listener = object : OnClickListener {

        override fun onClick(event: Event) {
            println("This is the source: ${event.source}")
        }
    }

    button.addOnClickListener(listener)

    button.click()
}
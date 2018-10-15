package com.skillcentric

// Inner and nested classes: kotlin -> nested by default, java -> inner by default
class MyButton {

    // Nested class demo (no reference to MyButton)
    // in java: static class NestedClass{}
    class NestedClass

    // Inner class demo (contains a reference to MyButton, i.e. this@MyButton)
    // in java: class InnerClass{}
    inner class InnerClass {

        fun demo(): String {

            // in java: MyButton.this.toString()
            return this@MyButton.toString()
        }
    }
}

fun main(args: Array<String>) {


}


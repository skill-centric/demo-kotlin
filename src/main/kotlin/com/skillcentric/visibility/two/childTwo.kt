package com.skillcentric.visibility.two

import com.skillcentric.visibility.one.Parent

class Child : Parent() {

    fun demo() {

        val parent = Parent()

        parent.publicMethod()
        parent.internalMethod()

//        parent.protectedMethod()
//        parent.privateMethod()
    }

    override fun publicMethod() {
        super.publicMethod()
        println("Some implementation")
    }

    override fun internalMethod() {
        super.internalMethod()
        println("Some implementation")
    }

    override fun protectedMethod() {
        super.protectedMethod()
        println("Some implementation")
    }
}
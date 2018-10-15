package com.skillcentric.visibility.one

class Child: Parent() {

    fun demo() {

        val parent = Parent()

        parent.publicMethod()
        parent.internalMethod()

//        parent.protectedMethod();
//        parent.privateMethod();

    }

    override fun publicMethod(){
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
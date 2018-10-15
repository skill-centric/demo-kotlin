package com.skillcentric.visibility.one

class notChildOne {

    fun demo() {

        val parent = Parent()

        parent.publicMethod()
        parent.internalMethod()

//        parent.protectedMethod()
//        parent.privateMethod()
    }
}
package com.skillcentric.visibility.two

import com.skillcentric.visibility.one.Parent

class NotChildTwo {

    fun demo() {

        val parent = Parent()

        parent.publicMethod()
        parent.internalMethod()

//        parent.protectedMethod()
//        parent.privateMethod()
    }
}
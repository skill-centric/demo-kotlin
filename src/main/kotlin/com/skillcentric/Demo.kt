package com.skillcentric

fun main(args: Array<String>) {

}

// lateinit
// Common use case: dependency injection

// late-initialized properties
class MyService {
    fun performAction(): String = "foo"
}

// Compiler doesn't allow you to leave non-null properties uninitialized
// Solution 1: you have to use nullable properties and initialize them later
class MyTest {

    // Declare a property of nullable type
    // and initialize it with null
    private var myService: MyService? = null

    // the real initializer
    fun setUp() {
        myService = MyService()
    }

    fun testAction() {

        // take care of nullability
        // with !! or ?.
        myService!!.performAction()
    }
}

// Solution 2: use lateinit modifier
class MySecondTest{

    private lateinit var myService: MyService

    fun setUp() {
        myService = MyService()
    }

    fun testAction() {

        myService.performAction()
    }


}














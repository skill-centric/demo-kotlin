package com.skillcentric.visibility

// Visibility modifiers
// Kotlin: public (default), internal, protected, private
// Java: public, protected, package-private (default), private

// 1. in java default modifier is package-private
// in kotlin the default modifier is public

// 2. in kotlin there is no package-private modifier
// in kotlin there is internal modifier -> javaVisibility in the whole module

// 3. In Java, you can access a protected member from the same package, but not in kotlin.
// In Kotlin, javaVisibility rules are simple, a protected member is only visible in the class and its subclasses.

// 4. In kotlin extension functions of a class don’t get access to its private or protected members.

// 5. In Kotlin: an outer class doesn’t see private members of its inner (or nested) classes.

open class Employee {

    fun publicMethod() {}

    internal fun internalMethod() {}

    protected fun protectedMethod() {}

    private fun privateMethod() {}
}



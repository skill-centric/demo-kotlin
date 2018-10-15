package com.skillcentric

// Primary constructor
class MyUser constructor(nickname: String) {

    val nickname: String

    // Initializer block
    init {
        this.nickname = nickname
    }
}

// The property is initialized by the parameter
class MyAnotherUser(nickname: String) {

    val nickname = nickname
}

// The above is the same as:
// (Primary constructor with properties)
class MyAnotherUserTwo(val nickname: String)

// Default values for constructor arguments
class Cat(val name: String = "Tom", val weight: Double = 5.00, var age: Int = 5)

fun demoConstructor() {

    // Note: no "new" is used to call the constructor
    val cat = Cat("Jack")
}

// Superclass constructor
open class InternetUser(val nickname: String)

class TwitterUser(nickname: String) : InternetUser(nickname)

// Default constructor is generated automatically
open class UniversityStudent

// When inheriting from a superclass, its constructor must be called in the subclass
// (note: interface have no constructor, so no () is necessary
// when implementing interfaces
class SmartStudent : UniversityStudent()

// Private constructor (i.e. the class cannot be extended)
class ClosedStudent private constructor(val firstName: String)

// or declare the private constructor in the body
class AnotherClosedStudent {
    private constructor(firstName: String)
}

// Secondary constructors
// (Mainly used for java interoperability)
interface Context

interface AttributeSet

open class AppView {

    constructor(context: Context)

    constructor(context: Context, attributes: AttributeSet)
}

// Calling superclass constructors
class AppButton : AppView {

    constructor(context: Context) : super(context)

    constructor(context: Context, attributes: AttributeSet) : super(context, attributes)
}

// Delegating to a constructor of the same class with "this" keyword
open class SomeView(context: Context, tag: String)

class AnotherAppButton : SomeView {

    constructor(context: Context) : this(context, "CUSTOM_TAG")

    constructor(context: Context, tag: String) : super(context, tag)
}

// Implementing properties declared in interfaces
interface AbsUser {
    val nickname: String // abstract property
}

// Interface Property is implemented as a parameter in the primary constructor
class PrivateUser(override val nickname: String) : AbsUser

// Interface Property is implemented via custom getter
class SubscribingUser(val email: String) : AbsUser {

    // no backing field
    // calculated on evey access
    override val nickname: String
        get() = email.substringBefore("@")
}

fun getFacebookName(accountId: Int) = "Random Name"

// Interface Property is implemented via property initializer
class FacebookUser(val accountId: Int) : AbsUser {

    // has a backing field,
    // calculated only on the first access
    override val nickname = getFacebookName(accountId)
}

// Interface properties with a getter
// have no backing field but can be inherited
interface AbstractUser {
    val email: String // this is abstract property, must be overriden in subclass
    val nickname: String // this is a property with a custom getter, can be inherited by subclass
        get() = email.substringBefore("@")
}

// Access the backing field from getter/setter using "field" keyword
// how to call: someUser.address = "Some Address"
class SomeUser(val name: String) {

    var address: String = "unspecified"
        get() {
            return field
        }
        set(value: String) {
            field = value
        }
}

// Changing accessor javaVisibility
class LengthCounter {

    var counter: Int = 0
    // getter is public and setter is private
        private set

    fun addWord(word: String) {

        counter += word.length
    }
}

// Very verbose, java-like constructor and property declarations
class Student {

    var name: String
        get() {
            return field
        }
        set(value: String) {

            if (value.length < 3)
                throw IllegalArgumentException("The name is too short!")

            field = value
        }


    constructor(name: String) {

        // Some validation logic in the secondary constructor
        if (name.length < 3)
            throw IllegalArgumentException("The name is too short!")

        this.name = name
    }

}

// Adding logic to primary constructor
class Professor(val lastName: String) {

    // Some validation logic for the primary constructor
    init {
        if (lastName.length < 3)
            throw IllegalArgumentException("The name is too short!")
    }
}

fun demoStudent() {

    val student = Student("Anton")
}

fun main(args: Array<String>) {


}


package com.skillcentric

// Companion Objects
// In Kotlin classes have no static methods and fields:
// top-level functions and object declarations replace them

// how to call: A.doSomeWork() (similar to calling static methods in java)
class A {

    companion object {

        fun doSomeWork() {
            // some logic...
        }
    }
}

// Factory methods are placed into companion objects
// how to call: ProductUser.newSubscribingUser("anton@gmail.com")
class ProductUser(val nickname: String) {

    // companion object declaration
    companion object {

        // factory method one:
        fun newSubscribingUser(email: String) =
                ProductUser(email.substringBefore("@"))

        // factory method two:
        fun newFacebookUser(accountId: Int) =
                ProductUser(getFacebookProductUserName(accountId))
    }
}

fun getFacebookProductUserName(accountId: Int) = "Anton Zav"

// Companion objects as regular objects
// Note: companion object can have a name (e.g. Loader)
// How to call: VipPerson.Loader.fromJson("test")
// How to call: VipPerson.fromJson("test")
// Both ways are OK
// By default the name of the companion object is "Companion"
data class VipPerson(val name: String) {

    companion object Loader {

        fun fromJson(jsonText: String): VipPerson {

            // some logic here...
            return VipPerson("test")
        }
    }
}

fun main(args: Array<String>){

    val person = VipPerson("Jack")
    println(person)
}

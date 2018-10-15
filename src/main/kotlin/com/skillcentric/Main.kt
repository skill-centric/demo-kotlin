package com.skillcentric

// Local function demo
class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {

    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Cannot save user ${user.id}: name is empty")
    }

    if (user.address.isEmpty())
        throw IllegalArgumentException("Cannot save user ${user.id}: address is empty")

    // save the user into db
}

fun saveUserWithLocalFunction(user: User) {

    fun validate(user: User, field: String, fieldName: String) {

        if (field.isEmpty())
            throw IllegalArgumentException("Cannot save user ${user.id}: $fieldName is empty.")
    }

    validate(user, user.name, "name")
    validate(user, user.address, "address")

    // save the user into db
}

fun saveUserWithLocalFunctionImproved(user: User) {

    // Note: local function can access outer function arguments (i.e. user)
    fun validate(field: String, fieldName: String) {

        if (field.isEmpty())
            throw IllegalArgumentException("Cannot save user ${user.id}: $fieldName is empty.")
    }

    validate(user.name, "name")
    validate(user.address, "address")

    // save the user into db
}

// Local function in extension function
fun User.validateBeforeSave() {

    fun validate(field: String, fieldName: String) {

        if (field.isEmpty())
            throw IllegalArgumentException("Cannot save user $id: $fieldName is empty")
    }

    validate(name, "name")
    validate(address, "address")
}

fun saveUserWithExtentionAndLocalFunctions(user: User) {

    user.validateBeforeSave()

    // save the user into db
}

fun main(args: Array<String>) {


}


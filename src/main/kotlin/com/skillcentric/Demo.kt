package com.skillcentric

// let function
fun sendEmail(email: String) {
    println("Sending email to $email")
}

fun main(args: Array<String>) {

    val emailOne: String? = "test@example.com"

//    // not allowed (type mismatch)
//    sendEmail(nullableEmail)

    // Allowed after not null check
    if (emailOne != null) {
        sendEmail(emailOne)
    }

    // let function
    // if not null
    emailOne?.let {

        sendEmail(it)
    }

    // let function
    // if null
    val emailTwo: String? = null
    emailTwo?.let {
        sendEmail(it)
    }
}

package com.skillcentric

import java.io.BufferedReader
import java.io.File
import java.lang.NumberFormatException

fun main(args: Array<String>) {


}

// Collections with nullable and non-nullable types
fun demoCollection() {

    val list: List<Int?> = listOf(1, 2, null, 3)

    val listTwo: List<Int> = listOf(1, 2, 3)
}

fun readNumbers(reader: BufferedReader): List<Int?> {

    val result = ArrayList<Int?>()

    for (line in reader.lineSequence()) {

        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }

    return result
}

fun addValidNumbers(numbers: List<Int?>) {

    val filterNotNull: List<Int> = numbers.filterNotNull()

}


// read-only VS mutable collections
fun demoCollectionsReadOnlyMutable() {

    val list: MutableCollection<Int> = arrayListOf(1, 2, 3)
    list.add(4)

//    // doesn't compile
//    val listTwo: Collection<Int> = arrayListOf(1, 2, 3)
//    listTwo.add(4)

}

// java code can mutate kotlin read-only collections:

// list is read only
fun printInUppercase(list: List<String>) {

    // but from java code it can be modified
    println(CollectionUtils.uppercaseAll(list))

    println(list.first())
}

class FileIndexer: FileContentProcessor {

    // When overriding from Java
    // we make the decision ourselves
    // whether the parameters are mutable or read only
    // and whether they are nullable or non nullable
    override fun processContents(file: File, binaryContents: ByteArray?, textContents: List<String>?) {

        // some implementation...
    }
}

class Person

class PersonParser: DataParser<Person> {

    // decide what is mutable/readonly, nullable/non-null
    // on the basis of implementation needs
    override fun parseData(input: String,
                           output: MutableList<Person>,
                           errors: MutableList<String?>) {

        // some implementation
    }
}













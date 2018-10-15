package com.skillcentric

import java.io.File

// Object declaration
// in java: a class with a static field which type is this class (i.e. singleton pattern)
// Note: constructors are not allowed
// how to call: Payroll.allEmployees.add("Mike")
// how to call: Payroll.calculateSalary()
// how to call in java: Payroll.INSTANCE.allEmpoyees.add("Mike")
// how to call in java: Payroll.INSTANCE.calculateSalary
object Payroll {

    val allEmployees = arrayListOf<String>()

    fun calculateSalary() {

        for (person in allEmployees) {
            // do some logic...
        }
    }
}

// how to call: CaseInsensitiveComparator.compare(File("/User"), File("/user"))
// how to call: listOfFiles.sortedWith(CaseInsensitiveComparator)
object CaseInsensitiveComparator : Comparator<File> {

    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

class Person(val name: String)

// Objects can be declared in a class
data class GreatPerson(val name: String) {

    // Only one instance per GreatPerson class
    // no individual instances per GreatPerson instances
    object NameComparator : Comparator<Person> {

        override fun compare(personOne: Person, personTwo: Person): Int {
            return personOne.name.compareTo(personTwo.name)
        }
    }
}
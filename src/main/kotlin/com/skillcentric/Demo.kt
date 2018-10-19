package com.skillcentric

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

fun main(args: Array<String>) {

    demoPropertiesInMap()
}

// Delegated property demo
class CustomType

class Foo {

    // 'by' keyword
    // it associates the property with the delegate
    private var p: CustomType by Delegate()
}

class Delegate {

    operator fun getValue(foo: Foo,
                          property: KProperty<*>): CustomType {
        TODO()
    }

    operator fun setValue(foo: Foo,
                          property: KProperty<*>,
                          customType: CustomType) {
        TODO()
    }
}

//// The compiler generates
//class Foo {
//
//    private val delegate = Delegate()
//
//    var p: CustomType
//        set(value: CustomType) = delegate.setValue(..., value)
//        get() = delegate.getValue(...)
//}


// (A) Demo lazy loading
// "Backing property" technique
// Implement lazy loading using an additional property that stores null
class Email

class ThePerson(val name: String) {

    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }

            return _emails!!
        }
}

fun loadEmails(person: ThePerson): List<Email> {

    println("Load emails for person ${person.name}")
    return listOf(Email())
}

fun demoLazyLoading() {

    val person = ThePerson("Alice")

    person.emails
    person.emails
    person.emails
}

// (B) Demo lazy standard library function
class ImprovedPerson(val name: String) {

    val emails by lazy { loadEmails(this) }
}

fun loadEmails(person: ImprovedPerson): List<Email> {

    println("Load emails for person ${person.name}")
    return listOf(Email())
}

// Implementing delegated properties
// (1) Use PropertyChangeSupport without delegated properties
open class PropertyChangeAware {

    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    var age: Int = age
        set(newValue) {

            val oldValue = field
            field = newValue

            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {

            val oldValue = field
            field = newValue

            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

fun demoWithoutDelegatedProperties() {

    val person = Person("Alice", 34, 2000)

    person.addPropertyChangeListener(
            PropertyChangeListener { event ->
                println("Property ${event.propertyName} has changed " +
                        "from  ${event.oldValue} " +
                        "to ${event.newValue}")
            })

    person.age = 35
    person.salary = 2100
}


// (2) Let's encapsulate the get/set logic into a class MyObservableProperty
class MyObservableProperty(val propName: String, var propValue: Int,
                           val changeSupport: PropertyChangeSupport) {

    fun getValue(): Int = propValue

    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue

        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class MyPerson(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    val _age = MyObservableProperty("age", age, changeSupport)
    var age: Int
        get() = _age.getValue()
        set(value) {
            _age.setValue(value)
        }

    val _salary = MyObservableProperty("salary", salary, changeSupport)
    var salary: Int
        get() = _salary.getValue()
        set(value) {
            _salary.setValue(value)
        }
}

// (3) Use kotlin property delegates
class SomeObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {

    operator fun getValue(p: SomePerson, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: SomePerson, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class SomePerson(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    var age: Int by SomeObservableProperty(age, changeSupport)

    var salary: Int by SomeObservableProperty(salary, changeSupport)
}

fun demoWithDelegatedProperties() {

    val person = SomePerson("Alice", 34, 2000)

    person.addPropertyChangeListener(PropertyChangeListener { event ->
        println("Property ${event.propertyName} has changed " +
                "from  ${event.oldValue} " +
                "to ${event.newValue}")
    })

    person.age = 35
    person.salary = 2100
}

// Final example
// (4) use standard library observable property class
class AnotherPerson(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

fun demoStLibObservableProperty() {

    val person = AnotherPerson("Alice", 34, 2000)

    person.addPropertyChangeListener(PropertyChangeListener { event ->
        println("Property ${event.propertyName} has changed " +
                "from  ${event.oldValue} " +
                "to ${event.newValue}")
    })

    person.age = 35
    person.salary = 2100
}

// // So how does property delegation works?
//class Foo {
//    var c: Type by MyDelegate()
//}
//
//class Foo {
//    private val <delegate> = MyDelegate()
//
//    var c: Type
//        get() = <delegate>.getValue(c, <property>)
//        set(value: Type) = <delegate>.setValue(c, <property>, value)
//}


// Storing property values in a map
// (1) without delegate
class TargetPerson {

    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String){
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!!
}

// (2) with delegate
class TargetTwoPerson {

    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String){
        _attributes[attrName] = value
    }

    // Note: 'by' keyword
    val name: String by _attributes
}

fun demoPropertiesInMap() {

    val person = TargetTwoPerson()

    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")

    for ((attrName, value) in data) {

        person.setAttribute(attrName, value)
    }

    println(person.name)
}






















package com.skillcentric.visibility.inOut

open class OuterKotlin {

    open inner class Inner {

        val publicProperty = 100
        internal val internalProperty = 200

        protected val protectedProperty = 300
        private val privateProperty = 400
    }

    fun demo() {

        val inner = Inner()

        val result1 = inner.publicProperty
        val result2 = inner.internalProperty

//        // In kotlin outer class cannot access protected and private properties of inner class
//        val result3 = inner.protectedProperty
//        val result4 = inner.privateProperty
    }
}
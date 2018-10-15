package com.skillcentric.visibility.inOut;

public class OuterJava {

    private class Inner{

        public int publicProperty = 100;

        protected int protectedProperty = 200;

        int packagePrivateProperty = 300;

        private int privateProperty = 400;
    }

    public void demo() {

        Inner inner = new Inner();

        // in java: outer class can access all properties of inner class (not in kotlin)
        int result1 = inner.publicProperty;

        int result2 = inner.protectedProperty;

        int result3 = inner.packagePrivateProperty;

        int result4 = inner.privateProperty;
    }
}

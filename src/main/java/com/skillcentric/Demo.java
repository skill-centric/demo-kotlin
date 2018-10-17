package com.skillcentric;

public class Demo {

    public static void main(String[] args) {

        Object myObj = 123;

        // throws ClassCastException at runtime
        String resultOne = (String) myObj;

        String resultTwo;

        if (myObj instanceof String) {
            resultTwo = (String) myObj;
        } else {
            resultTwo = null;
        }
    }
}

package com.skillcentric.visibility.two;


import com.skillcentric.visibility.one.ParentJava;

public class NonRelativeTwo {

    public void demo() {

        ParentJava parent = new ParentJava();
        parent.publicMethod();

//        parent.protectedMethod();
//        parent.packagePrivateMethod();
    }
}

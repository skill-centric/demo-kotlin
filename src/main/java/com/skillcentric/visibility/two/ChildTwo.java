package com.skillcentric.visibility.two;


import com.skillcentric.visibility.one.ParentJava;

public class ChildTwo extends ParentJava {

    public void demo() {

        ParentJava parent = new ParentJava();

        parent.publicMethod();

//        parent.protectedMethod();
//        parent.packagePrivateMethod();
    }

    @Override
    public String publicMethod() {
        return super.publicMethod();
    }

    @Override
    protected String protectedMethod() {
        return super.protectedMethod();
    }
}
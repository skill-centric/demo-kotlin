package com.skillcentric.visibility.one;

public class NonRelativeOne {

    public void demo() {

        ParentJava parent = new ParentJava();

        parent.publicMethod();

        // Note: non relative classes from the same package
        // can access protected methods (not in kotlin)
        parent.protectedMethod();

        parent.packagePrivateMethod();
    }
}

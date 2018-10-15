package com.skillcentric.visibility.one;

public class ChildOne extends ParentJava {

    public void demo() {

        ParentJava parent = new ParentJava();

        parent.publicMethod();
        parent.protectedMethod();
        parent.packagePrivateMethod();
    }

    @Override
    public String publicMethod() {
        return super.publicMethod();
    }

    @Override
    protected String protectedMethod() {
        return super.protectedMethod();
    }

    @Override
    String packagePrivateMethod() {
        return super.packagePrivateMethod();
    }
}

package com.skillcentric.visibility.one;

public class ParentJava {

    public String publicMethod() {
        return "public method";
    }

    protected String protectedMethod() {
        return "protected method";
    }

    String packagePrivateMethod() {
        return "package private method";
    }

    private String privateMethod() {
        return "private method";
    }
}

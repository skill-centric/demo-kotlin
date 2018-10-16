package com.skillcentric;

import java.util.Collection;
import java.util.function.Consumer;

class Count {
    int value = 0;

    public int getValue() {
        return value;
    }

    public void increment() {
        value++;
    }
}

public class DemoScopes {

    public static void main(String[] args) {

    }

    private void printProblemCounts(Collection<String> responses) {

//        // Note: java lambdas cannot access and modify non-final variables
//        // kotlin lambdas can
//        int clientProblems = 0;
//        int serverProblems = 0;
//
//        responses.forEach(e -> {
//
//            if (e.startsWith("4")) {
//                clientProblems++;
//            } else if (e.startsWith("5"))
//                serverProblems++;
//        });
//
//        // Note: java anonymous classes cannot access and modify non-final variables
//        // kotlin object expressions can
//        responses.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//
//                if (s.startsWith("4")) {
//                    clientProblems++;
//                } else if (s.startsWith("5")) {
//                    serverProblems++;
//                }
//            }
//        });
//
//        System.out.println("Client problems: " + clientProblems
//                + ", server problems: " + serverProblems);
    }

    // Note: java anonymous classes and lambdas can access
    // final and effectively final variables
    private void printProblemCountsCorrect(Collection<String> responses) {

        // non-final variables are wrapped into a final wrapper
        // kotlin does this under the hood
        final Count clientProblems = new Count();
        final Count serverProblems = new Count();

        responses.forEach(e -> {

            if (e.startsWith("4")) {
                clientProblems.increment();
            } else if (e.startsWith("5")) {
                serverProblems.increment();
            }
        });


        responses.forEach(new Consumer<String>() {
            @Override
            public void accept(String e) {

                if (e.startsWith("4")) {
                    clientProblems.increment();
                } else if (e.startsWith("5")) {
                    serverProblems.increment();
                }
            }
        });

        System.out.println("Client problems: " + clientProblems.getValue());
        System.out.println("Server problems: " + serverProblems.getValue());
    }
}

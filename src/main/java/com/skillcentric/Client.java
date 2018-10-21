package com.skillcentric;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.skillcentric.DemoKt.processTheAnswer;

public class Client {

    public static void main(String[] args) {

        // Call kotlin function
        // using java 8 lambdas
        processTheAnswer(number -> number + 100);

        // Call kotlin function
        // using an anonymous inner class (before java 8)
        processTheAnswer(new Function1<Integer, Integer>() {
            @Override
            public Integer invoke(Integer integer) {

                return integer + 100;
            }
        });

        // Calling an extension function from Kotlin standard library
        List<String> items = new ArrayList<>();
        items.addAll(Arrays.asList("100", "200", "300"));

        // forEach extension function is declared in the Collections.kt file
        CollectionsKt.forEach(items, element -> {

            System.out.println(element);

            // You must return an instance of Unit
            return Unit.INSTANCE;
        });
    }
}

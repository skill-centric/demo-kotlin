package com.skillcentric;

public class Actor {

    public void processDoable(Doable doable) {

        System.out.println("Doable is processed: " + doable.doJob("programmer"));
    }

    public void processDoableWithCapturing(String info, Doable doable) {

        System.out.println("Doable is processed: " + doable.doJob("programmer")
                + ", info: " + info);

    }

}

package com.skillcentric;

import org.jetbrains.annotations.NotNull;

public class Main {

    public void demoClicks(Button button) {

        int buttonClick = 0;

        button.addOnClickListener(new OnClickListener() {

            @Override
            public void onClick(@NotNull Event event) {

//                // not possible, because buttonClick must be final
//                buttonClick++;
            }
        });
    }

    public static void main(String[] args) {

    }
}

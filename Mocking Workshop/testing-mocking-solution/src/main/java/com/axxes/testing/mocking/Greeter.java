package com.axxes.testing.mocking;

public class Greeter {

    private static final String DEFAULT = "Hello there";

    String greet(String... names) {

        String name = names[0];

        if (name == null) {
            return DEFAULT;
        }

        if (name.equals(name.toUpperCase())) {
            return "HELLO " + names;
        }
        return "Hello, " + names;
    }

    private String handleMultipleNames(String[] names){
        if (names.length == 1) {
            return "Hello, " + names[0] + " and " + names[1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello, ");
        for (int i = 0; i < names.length - 1; i++) {
            stringBuilder
                    .append(names[i]);
            if (i != names.length - 2) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder
                .append(" and ")
                .append(names[names.length -1]);
        return stringBuilder.toString();
    }
}

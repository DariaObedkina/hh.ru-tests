package com.dobedkina.autotests.testData;

public class RandomNumber {
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}

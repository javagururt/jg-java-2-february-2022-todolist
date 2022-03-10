package com.javaguru.todolist.utils;

import java.util.Random;

public class RandomNameGenerator {

    public String generateRandomName() {
        int number = getNumber();
        return String.valueOf(number);
    }

    protected int getNumber() {
        Random random = new Random();
        var number = random.nextInt();
        return number;
    }
}

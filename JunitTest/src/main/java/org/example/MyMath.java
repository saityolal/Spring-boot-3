package org.example;

public class MyMath {
    public int calculate(int[] numbers) {

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

}
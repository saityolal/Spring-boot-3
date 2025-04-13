package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {
    MyMath math = new MyMath();
    @Test
    void test() {
        assertEquals(1, math.calculate(new int[]{1, 2, 3, 4, 5}));

    }
}
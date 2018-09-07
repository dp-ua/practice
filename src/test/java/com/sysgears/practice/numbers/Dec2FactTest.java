package com.sysgears.practice.numbers;

import static org.junit.Assert.*;
import org.junit.Test;

public class Dec2FactTest {
    @Test
    public void test11() {
        assertEquals(Dec2Fact.dec2FactString(1001L), "1212210");
    }
}

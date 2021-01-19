package com.app.creditcardprocessing.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void test_formatTo2DecimalPlaces() {
        Double value = 0.123;
        Double result = Util.formatTo2DecimalPlaces(value);
        assertEquals(result, 0.12);
    }
}

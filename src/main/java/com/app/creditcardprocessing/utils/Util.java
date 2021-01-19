package com.app.creditcardprocessing.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Util {

    public static BigDecimal formatTo2DecimalPlaces(BigDecimal value) {
        if(null == value) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("#.00");

        return value.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

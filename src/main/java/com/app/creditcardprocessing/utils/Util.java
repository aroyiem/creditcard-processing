package com.app.creditcardprocessing.utils;

import java.text.DecimalFormat;

public class Util {

    public static Double formatTo2DecimalPlaces(Double value) {
        if(null == value) {
            return null;
        }
        DecimalFormat df = new DecimalFormat("#.00");

        return Double.parseDouble(df.format(value));
    }
}

package com.harium.suneidesis.math.converter;

import com.harium.suneidesis.math.MeasurementConverter;

import java.math.BigDecimal;

public class LengthConverter implements MeasurementConverter {

    public static final String METER = "meter";
    public static final String MILE = "mile";
    public static final String KILOMETER = "kilometer";

    @Override
    public String convert(String amount, String unit, String outputUnit) {
        BigDecimal value = new BigDecimal(amount);
        if (METER.equals(unit) && KILOMETER.equals(outputUnit)) {
            return value.divide(new BigDecimal(1000)).toPlainString();
        } else if (KILOMETER.equals(unit) && METER.equals(outputUnit)) {
            return value.multiply(new BigDecimal(1000)).toPlainString();
        } else if (KILOMETER.equals(unit) && MILE.equals(outputUnit)) {
            return value.multiply(new BigDecimal(0.62137119)).toPlainString();
        } else if (MILE.equals(unit) && KILOMETER.equals(outputUnit)) {
            return value.multiply(new BigDecimal(1.609344)).toPlainString();
        }

        return "";
    }
}

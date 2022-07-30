package com.harium.suneidesis.math.converter;

import com.harium.suneidesis.math.MeasurementConverter;

import java.math.BigDecimal;

public class LengthConverter implements MeasurementConverter {

    public static final String METER = "meter";
    public static final String MILE = "mile";
    public static final String KILOMETER = "kilometer";
    public static final String FOOT = "foot";
    public static final String INCH = "inch";

    @Override
    public String convert(String amount, String unit, String outputUnit) {
        if (METER.equals(unit) && KILOMETER.equals(outputUnit)) {
            return meterToKilometer(amount);
        } else if (KILOMETER.equals(unit) && METER.equals(outputUnit)) {
            return kilometerToMeter(amount);
        } else if (MILE.equals(unit) && KILOMETER.equals(outputUnit)) {
            return mileToKilometer(amount);
        } else if (KILOMETER.equals(unit) && MILE.equals(outputUnit)) {
            return kilometerToMile(amount);
        } else if (METER.equals(unit) && MILE.equals(outputUnit)) {
            // Convert to common unit
            String kilometer = meterToKilometer(amount);
            return kilometerToMile(kilometer);
        } else if (METER.equals(unit) && FOOT.equals(outputUnit)) {
            return meterToFoot(amount);
        } else if (METER.equals(unit) && INCH.equals(outputUnit)) {
            return meterToInch(amount);
        }

        return "";
    }

    private String meterToKilometer(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.divide(BigDecimal.valueOf(1000)).toPlainString();
    }

    private String meterToFoot(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.multiply(BigDecimal.valueOf(3.28084)).toPlainString();
    }

    private String meterToInch(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.multiply(BigDecimal.valueOf(39.3701)).toPlainString();
    }

    private String kilometerToMeter(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.multiply(BigDecimal.valueOf(1000)).toPlainString();
    }

    private String kilometerToMile(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.multiply(BigDecimal.valueOf(0.62137119)).toPlainString();
    }

    private String mileToKilometer(String amount) {
        BigDecimal value = new BigDecimal(amount);
        return value.multiply(BigDecimal.valueOf(1.609344)).toPlainString();
    }
}

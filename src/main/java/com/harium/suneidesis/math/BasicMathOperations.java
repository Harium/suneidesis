package com.harium.suneidesis.math;

import java.math.BigDecimal;

public class BasicMathOperations implements MathOperations {

    @Override
    public String plus(String value1, String value2) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);

        return roundResult(a.add(b).doubleValue());
    }

    @Override
    public String minus(String value1, String value2) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);

        return roundResult(a.subtract(b).doubleValue());
    }

    @Override
    public String times(String value1, String value2) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);

        return roundResult(a.multiply(b).doubleValue());
    }

    @Override
    public String divide(String value1, String value2) {
        BigDecimal a = new BigDecimal(value1);
        BigDecimal b = new BigDecimal(value2);

        return roundResult(a.divide(b).doubleValue());
    }

    @Override
    public String percentOf(String total, String percentage) {
        BigDecimal t = new BigDecimal(total);
        BigDecimal p = new BigDecimal(percentage);

        double a = p.doubleValue() / 100 * t.doubleValue();
        return roundResult(a);
    }

    @Override
    public String percentageOf(String total, String percentage) {
        BigDecimal t = new BigDecimal(total);
        BigDecimal p = new BigDecimal(percentage);

        double a = p.doubleValue() * 100 / t.doubleValue();
        return roundResult(a);
    }

    private String roundResult(double result) {
        int i = (int) result;
        if (result - i == 0.0) {
            return String.valueOf(i);
        }

        return String.valueOf(result);
    }
}

package com.harium.suneidesis.linguistic.english.math;

import com.harium.suneidesis.linguistic.math.NumberToWord;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that turn numbers into words
 * Based on: https://www.programcreek.com/2014/05/leetcode-integer-to-english-words-java/
 */
public class SimpleNumberToWord implements NumberToWord {

    private static final int BILLION = 1000000000;
    private static final int MILLION = 1000000;
    private static final int THOUSAND = 1000;
    private static final int HUNDRED = 100;

    static Map<Integer, String> numbers = new HashMap<Integer, String>();
    {
        fillMap();
    }

    @Override
    public String toWord(int number) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) {
            return numbers.get(0);
        }

        number = check(number, sb, BILLION);
        number = check(number, sb, MILLION);
        number = check(number, sb, THOUSAND);
        number = check(number, sb, HUNDRED);

        if (number > 0) {
            sb.append(convert(number));
        }

        return sb.toString().trim();
    }

    private int check(int number, StringBuilder sb, int toCheck) {
        if (number >= toCheck) {
            int extra = number / toCheck;
            sb.append(convert(extra) + " " + numbers.get(toCheck));
            number = number % toCheck;
        }
        return number;
    }

    private String convert(int number) {
        StringBuilder sb = new StringBuilder();

        if (number > 0) {
            if (number > 0 && number <= 20) {
                sb.append(" " + numbers.get(number));
            } else {
                int numTen = number / 10;
                sb.append(" " + numbers.get(numTen * 10));

                int numOne = number % 10;
                if (numOne > 0) {
                    sb.append(" " + numbers.get(numOne));
                }
            }
        }

        return sb.toString();
    }

    public void fillMap() {
        numbers.put(0, "zero");
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");
        numbers.put(6, "six");
        numbers.put(7, "seven");
        numbers.put(8, "eight");
        numbers.put(9, "nine");
        numbers.put(10, "ten");
        numbers.put(11, "eleven");
        numbers.put(12, "twelve");
        numbers.put(13, "thirteen");
        numbers.put(14, "fourteen");
        numbers.put(15, "fifteen");
        numbers.put(16, "sixteen");
        numbers.put(17, "seventeen");
        numbers.put(18, "eighteen");
        numbers.put(19, "nineteen");
        numbers.put(20, "twenty");
        numbers.put(30, "thirty");
        numbers.put(40, "forty");
        numbers.put(50, "fifty");
        numbers.put(60, "sixty");
        numbers.put(70, "seventy");
        numbers.put(80, "eighty");
        numbers.put(90, "ninety");
        numbers.put(HUNDRED, "hundred");
        numbers.put(THOUSAND, "thousand");
        numbers.put(MILLION, "million");
        numbers.put(BILLION, "billion");
    }

    @Override
    public String toWord(double number) {
        return toWord((int) number);
    }

    @Override
    public String toWord(BigDecimal number) {
        return toWord(number.longValue());
    }
}

package com.harium.suneidesis.linguistic.portuguese.math;

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

    private static final String ONE_HUNDRED_LABEL = "cem";
    private static final String ONE_HUNDRED = "cento";
    private static final String TWO_HUNDRED = "duzentos";
    private static final String THREE_HUNDRED = "trezentos";
    private static final String FOUR_HUNDRED = "quatrocentos";
    private static final String FIVE_HUNDRED = "quinhentos";
    private static final String SIX_HUNDRED = "seiscentos";
    private static final String SEVEN_HUNDRED = "setecentos";
    private static final String EIGHT_HUNDRED = "oitocentos";
    private static final String NINE_HUNDRED = "novecentos";

    static Map<Integer, String> numbers = new HashMap<Integer, String>();
    static Map<Integer, String> plurals = new HashMap<Integer, String>();

    {
        fillMaps();
    }

    @Override
    public String toWord(int number) {
        StringBuilder sb = new StringBuilder();

        if (number == 0) {
            return numbers.get(0);
        } else if (number == THOUSAND) {
            return numbers.get(THOUSAND);
        }

        number = check(number, sb, BILLION);
        number = check(number, sb, MILLION);
        number = check(number, sb, THOUSAND);

        if (number > 0) {
            sb.append(convert(number));
        }

        return sb.toString().trim();
    }

    private int check(int number, StringBuilder sb, int toCheck) {
        if (number >= toCheck) {
            int extra = number / toCheck;
            if (extra == 1) {
                sb.append(convert(extra) + " " + numbers.get(toCheck));
            } else {
                if (plurals.containsKey(toCheck)) {
                    sb.append(convert(extra) + " " + plurals.get(toCheck));
                } else {
                    sb.append(convert(extra) + " " + numbers.get(toCheck));
                }
            }
            number = number % toCheck;
            if (number > 0) {
                sb.append(" e");
            }
        }
        return number;
    }

    private String convert(int number) {
        StringBuilder sb = new StringBuilder();

        if (number > 0) {
            if (number > 0 && number <= 20) {
                sb.append(" " + numbers.get(number));
            } else if (number == HUNDRED) {
                sb.append(ONE_HUNDRED_LABEL);
            } else if (number > HUNDRED && number <= THOUSAND) {
                int order = (number / HUNDRED) * HUNDRED;
                int extra = number % HUNDRED;

                sb.append(" " + numbers.get(order));

                if (extra > 0) {
                    sb.append(" e" + convert(extra));
                }
            } else {
                int numTen = number / 10;
                sb.append(" " + numbers.get(numTen * 10));

                int numOne = number % 10;
                if (numOne > 0) {
                    sb.append(" e " + numbers.get(numOne));
                }
            }
        }

        return sb.toString();
    }

    public void fillMaps() {
        numbers.put(0, "zero");
        numbers.put(1, "um");
        numbers.put(2, "dois");
        numbers.put(3, "três");
        numbers.put(4, "quatro");
        numbers.put(5, "cinco");
        numbers.put(6, "seis");
        numbers.put(7, "sete");
        numbers.put(8, "oito");
        numbers.put(9, "nove");
        numbers.put(10, "dez");
        numbers.put(11, "onze");
        numbers.put(12, "doze");
        numbers.put(13, "treze");
        numbers.put(14, "quatorze");
        numbers.put(15, "quinze");
        numbers.put(16, "dezesseis");
        numbers.put(17, "dezessete");
        numbers.put(18, "dezoito");
        numbers.put(19, "dezenove");
        numbers.put(20, "vinte");
        numbers.put(30, "trinta");
        numbers.put(40, "quarenta");
        numbers.put(50, "cinquenta");
        numbers.put(60, "sessenta");
        numbers.put(70, "setenta");
        numbers.put(80, "oitenta");
        numbers.put(90, "noventa");
        numbers.put(HUNDRED, ONE_HUNDRED);
        numbers.put(200, TWO_HUNDRED);
        numbers.put(300, THREE_HUNDRED);
        numbers.put(400, FOUR_HUNDRED);
        numbers.put(500, FIVE_HUNDRED);
        numbers.put(600, SIX_HUNDRED);
        numbers.put(700, SEVEN_HUNDRED);
        numbers.put(800, EIGHT_HUNDRED);
        numbers.put(900, NINE_HUNDRED);
        numbers.put(THOUSAND, "mil");
        numbers.put(MILLION, "milhão");
        numbers.put(BILLION, "bilhão");

        plurals.put(MILLION, "milhões");
        plurals.put(BILLION, "bilhões");
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

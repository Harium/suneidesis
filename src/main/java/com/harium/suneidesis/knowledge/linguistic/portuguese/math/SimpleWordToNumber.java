package com.harium.suneidesis.knowledge.linguistic.portuguese.math;

import com.harium.suneidesis.knowledge.linguistic.core.math.WordToNumber;

import java.math.BigDecimal;

public class SimpleWordToNumber implements WordToNumber {

    private static final String ZERO = "zero";
    private static final String ONE = "um";
    private static final String TWO = "dois";
    private static final String THREE = "três";
    private static final String FOUR = "quatro";
    private static final String FIVE = "cinco";
    private static final String SIX = "seis";
    private static final String SEVEN = "sete";
    private static final String EIGHT = "oito";
    private static final String NINE = "nove";
    private static final String TEN = "dez";
    private static final String ELEVEN = "onze";
    private static final String TWELVE = "doze";
    private static final String THIRTEEN = "treze";
    private static final String FOURTEEN = "quatorze";
    private static final String FOURTEEN_ALTERNATIVE = "catorze";
    private static final String FIFTEEN = "quinze";
    private static final String SIXTEEN = "dezesseis";
    private static final String SEVENTEEN = "dezessete";
    private static final String EIGHTEEN = "dezoito";
    private static final String NINETEEN = "dezenove";
    private static final String TWENTY = "vinte";
    private static final String THIRTY = "trinta";
    private static final String FOURTY = "quarenta";
    private static final String FIFTY = "cinquenta";
    private static final String SIXTY = "sessenta";
    private static final String SEVENTY = "setenta";
    private static final String EIGHTY = "oitenta";
    private static final String NINETY = "noventa";
    private static final String HUNDRED = "cem";
    private static final String HUNDRED_COMPOSITE = "cento";
    private static final String TWO_HUNDRED = "duzentos";
    private static final String THREE_HUNDRED = "trezentos";
    private static final String FOUR_HUNDRED = "quatrocentos";
    private static final String FIVE_HUNDRED = "quinhentos";
    private static final String SIX_HUNDRED = "seiscentos";
    private static final String SEVEN_HUNDRED = "setecentos";
    private static final String EIGHT_HUNDRED = "oitocentos";
    private static final String NINE_HUNDRED = "novecentos";
    private static final String THOUSAND = "mil";
    private static final String MILLION = "milhão";
    private static final String MILLION_PLURAL = "milhões";
    private static final String BILLION = "bilhão";
    private static final String BILLION_PLURAL = "bilhões";

    @Override
    public BigDecimal toNumber(String word) {
        String[] parts = word.split(" ");

        long safe = 0;
        long number = 0;

        int count = 0;
        while (count < parts.length) {
            if ("e".equals(parts[count])) {
                count++;
                continue;
            }

            long n = singleWord(parts[count]);

            if (n == 1000 && number > 0) {
                number *= 1000;
            } else if (n == 1000000 && number > 0) {
                number *= 1000000;
                safe += number;
                number = 0;
            } else if (n == 1000000000 && number > 0) {
                number *= 1000000000;
                safe += number;
                number = 0;
            } else {
                number += n;
            }
            count++;
        }

        return new BigDecimal(safe + number);
    }

    private long singleWord(String word) {
        if (ZERO.equals(word)) {
            return 0;
        } else if (ONE.equals(word)) {
            return 1;
        } else if (TWO.equals(word)) {
            return 2;
        } else if (THREE.equals(word)) {
            return 3;
        } else if (FOUR.equals(word)) {
            return 4;
        } else if (FIVE.equals(word)) {
            return 5;
        } else if (SIX.equals(word)) {
            return 6;
        } else if (SEVEN.equals(word)) {
            return 7;
        } else if (EIGHT.equals(word)) {
            return 8;
        } else if (NINE.equals(word)) {
            return 9;
        } else if (TEN.equals(word)) {
            return 10;
        } else if (ELEVEN.equals(word)) {
            return 11;
        } else if (TWELVE.equals(word)) {
            return 12;
        } else if (THIRTEEN.equals(word)) {
            return 13;
        } else if (FOURTEEN.equals(word) || FOURTEEN_ALTERNATIVE.equals(word)) {
            return 14;
        } else if (FIFTEEN.equals(word)) {
            return 15;
        } else if (SIXTEEN.equals(word)) {
            return 16;
        } else if (SEVENTEEN.equals(word)) {
            return 17;
        } else if (EIGHTEEN.equals(word)) {
            return 18;
        } else if (NINETEEN.equals(word)) {
            return 19;
        } else if (TWENTY.equals(word)) {
            return 20;
        } else if (THIRTY.equals(word)) {
            return 30;
        } else if (FOURTY.equals(word)) {
            return 40;
        } else if (FIFTY.equals(word)) {
            return 50;
        } else if (SIXTY.equals(word)) {
            return 60;
        } else if (SEVENTY.equals(word)) {
            return 70;
        } else if (EIGHTY.equals(word)) {
            return 80;
        } else if (NINETY.equals(word)) {
            return 90;
        } else if (HUNDRED.equals(word) || HUNDRED_COMPOSITE.equals(word)) {
            return 100;
        } else if (TWO_HUNDRED.equals(word)) {
            return 200;
        } else if (THREE_HUNDRED.equals(word)) {
            return 300;
        } else if (FOUR_HUNDRED.equals(word)) {
            return 400;
        } else if (FIVE_HUNDRED.equals(word)) {
            return 500;
        } else if (SIX_HUNDRED.equals(word)) {
            return 600;
        } else if (SEVEN_HUNDRED.equals(word)) {
            return 700;
        } else if (EIGHT_HUNDRED.equals(word)) {
            return 800;
        } else if (NINE_HUNDRED.equals(word)) {
            return 900;
        } else if (THOUSAND.equals(word)) {
            return 1000;
        } else if (MILLION.equals(word) || MILLION_PLURAL.equals(word)) {
            return 1000000;
        } else if (BILLION.equals(word) || BILLION_PLURAL.equals(word)) {
            return 1000000000;
        }
        return 0;
    }
}

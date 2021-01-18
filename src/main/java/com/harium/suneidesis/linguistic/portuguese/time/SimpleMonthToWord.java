package com.harium.suneidesis.linguistic.portuguese.time;

import com.harium.suneidesis.linguistic.math.NumberToWord;

import java.math.BigDecimal;

public class SimpleMonthToWord implements NumberToWord {

    @Override
    public String toWord(int i) {
        switch (i) {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
        }
        return "";
    }

    @Override
    public String toWord(double v) {
        return toWord((int) v);
    }

    @Override
    public String toWord(BigDecimal bigDecimal) {
        return toWord(bigDecimal.intValue());
    }
}


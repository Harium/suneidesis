package com.harium.suneidesis.linguistic.math;

import java.math.BigDecimal;

public interface WordToNumber {
    /**
     * Method that receives a sentence and translates to a number
     * @param sentence sanitized (preferably lower case)
     * @return the number or null
     */
    BigDecimal toNumber(String sentence);
}

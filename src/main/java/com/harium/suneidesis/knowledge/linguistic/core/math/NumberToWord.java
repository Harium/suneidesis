package com.harium.suneidesis.knowledge.linguistic.core.math;

import java.math.BigDecimal;

public interface NumberToWord {
    String toWord(int number);
    String toWord(double number);
    String toWord(BigDecimal number);
}

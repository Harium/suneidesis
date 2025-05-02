package com.harium.suneidesis.math;

public class SequenceSolver {

    public enum PatternType {
        ARITHMETIC, GEOMETRIC, INSUFFICIENT_DATA, UNKNOWN
    }

    public PatternType detectPattern(String... terms) {
        if (terms.length < 2) {
            return PatternType.INSUFFICIENT_DATA;
        }

        int[] sequence = new int[terms.length];
        try {
            for (int i = 0; i < terms.length; i++) {
                sequence[i] = Integer.parseInt(terms[i]);
            }
        } catch (NumberFormatException e) {
            return PatternType.UNKNOWN;
        }

        boolean isArithmetic = true;
        boolean isGeometric = true;

        int commonDifference = sequence[1] - sequence[0];
        double commonRatio = (double) sequence[1] / sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != commonDifference) {
                isArithmetic = false;
            }

            if (sequence[i - 1] != 0 && (double) sequence[i] / sequence[i - 1] != commonRatio) {
                isGeometric = false;
            }
        }

        if (isArithmetic) {
            return PatternType.ARITHMETIC;
        } else if (isGeometric) {
            return PatternType.GEOMETRIC;
        } else {
            return PatternType.UNKNOWN;
        }
    }
}

package com.harium.suneidesis.math;

public interface SequenceDetector {
    SequenceSolver.PatternType detectPattern(String... terms);
}

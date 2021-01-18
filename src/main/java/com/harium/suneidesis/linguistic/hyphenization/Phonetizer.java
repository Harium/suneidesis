package com.harium.suneidesis.linguistic.hyphenization;

import java.util.List;

public interface Phonetizer {
    List<String> phonetize(String word);
}

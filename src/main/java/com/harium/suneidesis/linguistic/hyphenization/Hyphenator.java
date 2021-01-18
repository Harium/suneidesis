package com.harium.suneidesis.linguistic.hyphenization;

import java.util.List;

public interface Hyphenator {
    List<String> hyphenate(String word);
}

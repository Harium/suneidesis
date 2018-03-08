package com.harium.suneidesis.knowledge.linguistic.core.hyphenization;

import java.util.List;

public interface Hyphenator {
    List<String> hyphenate(String word);
}

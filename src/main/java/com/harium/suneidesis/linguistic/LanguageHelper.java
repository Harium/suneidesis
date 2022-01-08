package com.harium.suneidesis.linguistic;

import com.harium.suneidesis.linguistic.math.NumberToWord;
import com.harium.suneidesis.linguistic.math.WordToNumber;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public interface LanguageHelper extends NumberToWord, WordToNumber {

    Tag getTagFromText(String tagText);

    String getLanguageCode(String languageName);

    String getLanguageName(String languageCode);
}

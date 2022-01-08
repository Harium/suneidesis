package com.harium.suneidesis.linguistic.english;

import com.harium.suneidesis.linguistic.LanguageCode;
import com.harium.suneidesis.linguistic.LanguageHelper;
import com.harium.suneidesis.linguistic.english.math.SimpleNumberToWord;
import com.harium.suneidesis.linguistic.math.NumberToWord;
import com.harium.suneidesis.linguistic.math.WordToNumber;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.portuguese.math.SimpleWordToNumber;

import java.math.BigDecimal;

public class English implements LanguageHelper {

    private final NumberToWord numberToWord = new SimpleNumberToWord();

    private final WordToNumber wordToNumber = new SimpleWordToNumber();

    @Override
    public Tag getTagFromText(String tagText) {
        if (tagText == null || tagText.isEmpty()) {
            return null;
        }

        String tag = tagText.toLowerCase();

        if ("determiner".equalsIgnoreCase(tag)) {
            return Tag.DETERMINER;
        } else if ("adjective".equalsIgnoreCase(tag)) {
            return Tag.ADJECTIVE;
        } else if ("adverb".equalsIgnoreCase(tag)) {
            return Tag.ADVERB;
        } else if ("numeral".equalsIgnoreCase(tag)) {
            return Tag.NUMERAL;
        } else if ("conjunction".equalsIgnoreCase(tag)) {
            return Tag.CONJUCTION;
        } else if ("interjection".equalsIgnoreCase(tag)) {
            return Tag.INTERJECTION;
        } else if ("verb".equalsIgnoreCase(tag)) {
            return Tag.VERB;
        } else if ("verb conjugation".equalsIgnoreCase(tag)) {
            return Tag.VERB_CONJUGATION;
        } else if ("noun".equalsIgnoreCase(tag)) {
            return Tag.NOUN;
        } else if ("proper noun".equalsIgnoreCase(tag)) {
            return Tag.NOUN_PROPER;
        } else if ("personal pronoun".equalsIgnoreCase(tag)) {
            return Tag.PERSONAL_PRONOUN;
        } else if ("pronoun".equalsIgnoreCase(tag)) {
            return Tag.PRONOUN;
        } else if ("preposition".equalsIgnoreCase(tag)) {
            return Tag.PREPOSITION;
        }

        return null;
    }

    @Override
    public String getLanguageCode(String languageName) {
        if (languageName == null || languageName.isEmpty()) {
            return null;
        }
        if ("english".equalsIgnoreCase(languageName)) {
            return LanguageCode.ENGLISH;
        } else if ("french".equalsIgnoreCase(languageName)) {
            return LanguageCode.FRENCH;
        } else if ("portuguese".equalsIgnoreCase(languageName)) {
            return LanguageCode.PORTUGUESE;
        }
        return null;
    }

    @Override
    public String toWord(int number) {
        return numberToWord.toWord(number);
    }

    @Override
    public String toWord(double number) {
        return numberToWord.toWord(number);
    }

    @Override
    public String toWord(BigDecimal number) {
        return numberToWord.toWord(number);
    }

    @Override
    public BigDecimal toNumber(String sentence) {
        return wordToNumber.toNumber(sentence);
    }

    public static boolean isEnglish(String language) {
        if (language == null || language.isEmpty()) {
            return false;
        }
        return language.startsWith(LanguageCode.ENGLISH);
    }
}

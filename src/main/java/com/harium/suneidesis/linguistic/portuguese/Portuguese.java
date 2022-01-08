package com.harium.suneidesis.linguistic.portuguese;

import com.harium.suneidesis.linguistic.LanguageCode;
import com.harium.suneidesis.linguistic.LanguageHelper;
import com.harium.suneidesis.linguistic.math.NumberToWord;
import com.harium.suneidesis.linguistic.math.WordToNumber;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.portuguese.math.SimpleNumberToWord;
import com.harium.suneidesis.linguistic.portuguese.math.SimpleWordToNumber;

import java.math.BigDecimal;

public class Portuguese implements LanguageHelper {

    private final NumberToWord numberToWord = new SimpleNumberToWord();

    private final WordToNumber wordToNumber = new SimpleWordToNumber();

    public static boolean hasTilde(char c) {
        return c == 'ã' || c == 'õ';
    }

    public static boolean isCrescentTriphthong(String triphthong) {
        char first = triphthong.charAt(0);
        char second = triphthong.charAt(1);
        char third = triphthong.charAt(2);

        return !isSemiVowel(first) && isSemiVowel(second) && !isSemiVowel(third);
    }

    public static boolean isCrescentDiphthong(String diphthong) {
        char second = diphthong.charAt(1);
        char first = diphthong.charAt(0);
        if (hasAcute(second)) {
            return true;
        } else if (first == second) {
            return true;
        }

        return isSemiVowel(first) && !isSemiVowel(second);
    }

    public static boolean hasAcute(char vowel) {
        return vowel == 'á' || vowel == 'é' || vowel == 'í' || vowel == 'ó' || vowel == 'ú';
    }

    public static boolean isDecrescentDiphthong(String diphthong) {
        return !isCrescentDiphthong(diphthong);
    }

    public static boolean isSemiVowel(char vowel) {
        return vowel == 'i' || vowel == 'u';
    }

    public static boolean isDiphthongDigraphe(int index, String word) {
        boolean rules = (word.charAt(index) == 'g' && word.charAt(index + 1) == 'u')
                || (word.charAt(index) == 'q' && word.charAt(index + 1) == 'u');
        return rules;
    }

    public static boolean isDigraphe(int index, String word) {
        boolean rules = (word.charAt(index) == 'r' && word.charAt(index + 1) == 'r')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 's')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 'c')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 'ç')
                || (word.charAt(index) == 'x' && word.charAt(index + 1) == 's')
                || (word.charAt(index) == 'x' && word.charAt(index + 1) == 'c');
        return rules;
    }

    public static boolean isConsonantCluster(int index, String word) {
        boolean rules =
                (word.charAt(index) == 'b' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 'b' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 'c' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 'c' && word.charAt(index + 1) == 'h')
                        || (word.charAt(index) == 'c' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 'd' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 'f' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 'f' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 'g' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 'g' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 'l' && word.charAt(index + 1) == 'h')
                        || (word.charAt(index) == 'n' && word.charAt(index + 1) == 'h')
                        || (word.charAt(index) == 'p' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 'p' && word.charAt(index + 1) == 'r')
                        || (word.charAt(index) == 't' && word.charAt(index + 1) == 'l')
                        || (word.charAt(index) == 't' && word.charAt(index + 1) == 'r');
        return rules;
    }

    public static boolean isTriphthong(String chunk) {
        return vowelCount(chunk) == 3;
    }

    public static boolean isDiphthong(String chunk) {
        return vowelCount(chunk) == 2;
    }

    public static int vowelCount(String word) {
        return vowelCount(0, word);
    }

    public static int vowelCount(int index, String word) {
        int count = 0;
        for (int i = index; i < word.length(); i++) {
            if (isVowel(word.charAt(i))) {
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    public static boolean isConsonant(int index, String word) {
        return isConsonant(word.charAt(index));
    }

    public static boolean isConsonant(char c) {
        return !isVowel(c);
    }

    public static boolean isVowel(int index, String word) {
        return isVowel(word.charAt(index));
    }

    public static boolean isVowel(char c) {
        switch (rawVowel(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    public static char rawVowel(char vowel) {
        switch (vowel) {
            case 'á':
            case 'à':
            case 'â':
            case 'ã':
                return 'a';
            case 'é':
            case 'ê':
                return 'e';
            case 'í':
                return 'i';
            case 'ó':
            case 'ô':
            case 'õ':
                return 'o';
            case 'ú':
            case 'ü':
                return 'u';
            default:
                return vowel;
        }
    }

    public static char vowelWithTilde(char rawVowel) {
        switch (rawVowel) {
            case 'a':
                return 'ã';
            case 'e':
                return 'ẽ';
            case 'i':
                return 'ĩ';
            case 'o':
                return 'õ';
            case 'u':
                return 'ũ';
            default:
                return rawVowel;
        }
    }

    @Override
    public Tag getTagFromText(String tagText) {
        if (tagText == null || tagText.isEmpty()) {
            return null;
        }

        String tag = tagText.toLowerCase();

        if ("artigo".equalsIgnoreCase(tag)) {
            return Tag.DETERMINER;
        } else if ("adjetivo".equalsIgnoreCase(tag)) {
            return Tag.ADJECTIVE;
        } else if ("advérbio".equalsIgnoreCase(tag)) {
            return Tag.ADVERB;
        } else if ("numeral".equalsIgnoreCase(tag)) {
            return Tag.NUMERAL;
        } else if ("conjunção".equalsIgnoreCase(tag)) {
            return Tag.CONJUCTION;
        } else if ("interjeição".equalsIgnoreCase(tag)) {
            return Tag.INTERJECTION;
        } else if ("verbo".equalsIgnoreCase(tag)) {
            return Tag.VERB;
        } else if ("conjugação verbal".equalsIgnoreCase(tag)) {
            return Tag.VERB_CONJUGATION;
        } else if ("substantivo".equalsIgnoreCase(tag)) {
            return Tag.NOUN;
        } else if ("substantivo próprio".equalsIgnoreCase(tag)) {
            return Tag.NOUN_PROPER;
        } else if ("pronome pessoal".equalsIgnoreCase(tag)) {
            return Tag.PERSONAL_PRONOUN;
        } else if ("pronome".equalsIgnoreCase(tag)) {
            return Tag.PRONOUN;
        } else if ("preposição".equalsIgnoreCase(tag)) {
            return Tag.PREPOSITION;
        }

        return null;
    }

    @Override
    public String getLanguageCode(String languageName) {
        if (languageName == null || languageName.isEmpty()) {
            return null;
        }
        if ("inglês".equalsIgnoreCase(languageName)) {
            return LanguageCode.ENGLISH;
        } else if ("francês".equalsIgnoreCase(languageName)) {
            return LanguageCode.FRENCH;
        } else if ("português".equalsIgnoreCase(languageName)) {
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

    public static boolean isPortuguese(String language) {
        if (language == null || language.isEmpty()) {
            return false;
        }
        return language.startsWith(LanguageCode.PORTUGUESE);
    }
}

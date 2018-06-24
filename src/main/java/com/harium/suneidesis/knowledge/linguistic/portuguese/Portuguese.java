package com.harium.suneidesis.knowledge.linguistic.portuguese;

public class Portuguese {

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
}

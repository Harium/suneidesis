package com.harium.suneidesis.linguistic.portuguese;

import com.harium.suneidesis.linguistic.core.hyphenization.Hyphenator;

import java.util.ArrayList;
import java.util.List;

public class SimpleHyphenator implements Hyphenator {

    @Override
    public List<String> hyphenate(String word) {
        List<String> chunks = new ArrayList<String>();
        int index = 0;

        int joinLastChunk = Integer.MAX_VALUE;
        //String joinLastChunk = "";

        while (index < word.length()) {

            if (joinLastChunk < index) {
                String toJoin = chunks.get(joinLastChunk - 1);
                String chunk = chunks.get(joinLastChunk);
                chunks.set(joinLastChunk, toJoin + chunk);
                chunks.remove(joinLastChunk - 1);
                joinLastChunk = Integer.MAX_VALUE;
            }

            if (isVowel(index, word)) {
                int count = vowelCount(index, word);
                String chunk = word.substring(index, index + count);

                if (isDiphthong(chunk) && isCrescentDiphthong(chunk)) {
                    chunks.add("" + word.charAt(0));
                    chunks.add("" + word.charAt(1));
                    index += 2;
                } else {
                    chunks.add(chunk);
                    index += count;
                }

                continue;
            } else { // Starts with consonant
                // Skip the consonant
                int count = vowelCount(index + 1, word);

                // Consonant Clusters
                if (count == 0) {
                    // Word ended in consonant
                    if (index == word.length() - 1) {
                        String lastChunk = lastChunk(chunks);
                        lastChunk += word.charAt(index);
                        chunks.set(chunks.size() - 1, lastChunk);
                        index++;
                        continue;
                    }

                    if (isConsonantCluster(index, word)) {
                        int consonantClusterLength = 2;
                        int vowelCount = vowelCount(index + consonantClusterLength, word);
                        String chunk = word.substring(index, index + consonantClusterLength + vowelCount);
                        chunks.add(chunk);
                        index += consonantClusterLength + vowelCount;
                        continue;
                    } else {
                        if (!chunks.isEmpty()) {
                            String lastChunk = lastChunk(chunks);
                            lastChunk += word.charAt(index);

                            // Possible exceptions with chunks starting with b
                            if (chunks.size() > 1 && lastChunk.startsWith("b")) {
                                if (lastChunk.endsWith("p") || lastChunk.endsWith("n")) {
                                    int previousIndex = chunks.size() - 2;
                                    String previousChunk = chunks.get(previousIndex);
                                    previousChunk += "b";
                                    chunks.set(previousIndex, previousChunk);

                                    lastChunk = lastChunk.substring(1);
                                }
                            }

                            chunks.set(chunks.size() - 1, lastChunk);
                            index++;
                            continue;
                        } else {
                            chunks.add("" + word.charAt(index));
                            index++;
                            joinLastChunk = index;
                            continue;
                        }
                    }
                } else {
                    String vowelChunk = word.substring(index + 1, index + count + 1);

                    if (isTriphthong(vowelChunk)) {
                        if (isCrescentTriphthong(vowelChunk)) {
                            String chunk = word.substring(index, index + 3);
                            chunks.add(chunk);
                            index += 3;
                        } else if (hasTilde(word.charAt(index + 2))) {
                            // Possible Exceptions
                            if (vowelChunk.startsWith("u")) {
                                String chunk = word.substring(index, index + count + 1);
                                chunks.add(chunk);
                                index += count + 3;
                            } else {
                                String chunk = word.substring(index, index + 2);
                                chunks.add(chunk);
                                index += 2;
                            }
                        } else {
                            if (vowelChunk.endsWith("au")) {
                                String chunk = word.substring(index, index + 2);
                                chunks.add(chunk);
                                chunk = word.substring(index+2, index + 4);
                                chunks.add(chunk);
                                index += 4;
                            } else {
                                String chunk = word.substring(index, index + count + 1);
                                chunks.add(chunk);
                                index += count + 3;
                            }

                        }
                    } else if (isDiphthong(vowelChunk)) {
                        if (isDiphthongDigraphe(index, word) || !isCrescentDiphthong(vowelChunk)) {
                            // Decrescent
                            String chunk = word.substring(index, index + count + 1);
                            chunks.add(chunk);
                            index += count + 1;
                            continue;
                        } else {
                            // Crescent
                            String chunk = word.substring(index, index + 2);
                            chunks.add(chunk);
                            index += 2;
                            continue;
                        }
                    } else {
                        String chunk = word.substring(index, index + count + 1);
                        chunks.add(chunk);
                        index += count + 1;
                    }
                }
            }
        }

        return chunks;
    }

    static boolean isCrescentTriphthong(String triphthong) {
        char first = triphthong.charAt(0);
        char second = triphthong.charAt(1);
        char third = triphthong.charAt(2);

        return !isSemiVowel(first) && isSemiVowel(second) && !isSemiVowel(third);
    }

    private static boolean hasTilde(char c) {
        return c == 'ã' || c == 'õ';
    }

    static boolean isCrescentDiphthong(String diphthong) {
        char second = diphthong.charAt(1);
        char first = diphthong.charAt(0);
        if (hasAcute(second)) {
            return true;
        } else if (first == second) {
            return true;
        }

        return isSemiVowel(first) && !isSemiVowel(second);
    }

    private static boolean hasAcute(char vowel) {
        return vowel == 'á' || vowel == 'é' || vowel == 'í' || vowel == 'ó' || vowel == 'ú';
    }

    static boolean isDecrescentDiphthong(String diphthong) {
        return !isCrescentDiphthong(diphthong);
    }

    private static boolean isSemiVowel(char vowel) {
        return vowel == 'i' || vowel == 'u';
    }

    private boolean isDiphthongDigraphe(int index, String word) {
        boolean rules = (word.charAt(index) == 'g' && word.charAt(index + 1) == 'u')
                || (word.charAt(index) == 'q' && word.charAt(index + 1) == 'u');
        return rules;
    }

    private boolean isDigraphe(int index, String word) {
        boolean rules = (word.charAt(index) == 'r' && word.charAt(index + 1) == 'r')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 's')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 'c')
                || (word.charAt(index) == 's' && word.charAt(index + 1) == 'ç')
                || (word.charAt(index) == 'x' && word.charAt(index + 1) == 's')
                || (word.charAt(index) == 'x' && word.charAt(index + 1) == 'c');
        return rules;
    }

    private boolean isConsonantCluster(int index, String word) {
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

    private String lastChunk(List<String> chunks) {
        return chunks.get(chunks.size() - 1);
    }

    static boolean isTriphthong(String chunk) {
        return vowelCount(chunk) == 3;
    }

    static boolean isDiphthong(String chunk) {
        return vowelCount(chunk) == 2;
    }

    static int vowelCount(String word) {
        return vowelCount(0, word);
    }

    static int vowelCount(int index, String word) {
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

    private boolean isConsonant(int index, String word) {
        return isConsonant(word.charAt(index));
    }

    static boolean isConsonant(char c) {
        return !isVowel(c);
    }

    private boolean isVowel(int index, String word) {
        return isVowel(word.charAt(index));
    }

    static boolean isVowel(char c) {
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

    static char rawVowel(char c) {
        switch (c) {
            case 'á':
            case 'à':
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
                return c;
        }
    }
}

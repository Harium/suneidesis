package com.harium.suneidesis.knowledge.linguistic.portuguese;

import com.harium.suneidesis.knowledge.linguistic.core.hyphenization.Hyphenator;
import com.harium.suneidesis.knowledge.linguistic.core.hyphenization.Phonetizer;

import java.util.ArrayList;
import java.util.List;

public class RuleBasedPhonetizer implements Phonetizer {

    private Hyphenator hyphenator;

    public RuleBasedPhonetizer() {
        hyphenator = new RuleBasedHyphenator();
    }

    @Override
    public List<String> phonetize(String word) {
        List<String> syllables = hyphenator.hyphenate(word);
        List<String> phonemes = new ArrayList<String>();

        int index = 0;
        for (String syllable : syllables) {
            List<String> extracted = extractPhoneme(index, syllable, syllables, phonemes);
            fix(extracted);

            phonemes.addAll(extracted);
            index++;
        }

        return phonemes;
    }

    public List<String> syllabicPhonetize(String word) {
        List<String> syllables = hyphenator.hyphenate(word);
        List<String> phonemes = new ArrayList<String>();

        int index = 0;
        for (String syllable : syllables) {
            List<String> extracted = extractPhoneme(index, syllable, syllables, phonemes);
            fix(extracted);

            String phonemeSyllable = "";
            for(String phoneme:extracted) {
                phonemeSyllable += phoneme;
            }

            phonemes.add(phonemeSyllable);
            index++;
        }

        return phonemes;
    }

    private void fix(List<String> phonemes) {
        // Fix nasal vowels
        int last = phonemes.size() - 1;
        String lastPhoneme = phonemes.get(last);

        if ("m".equals(lastPhoneme) || "n".equals(lastPhoneme)) {
            phonemes.remove(last);
            char vowel = Portuguese.rawVowel(phonemes.get(last - 1).charAt(0));
            phonemes.add(String.valueOf(Portuguese.vowelWithTilde(vowel)));
            phonemes.remove(last - 1);
        }
    }

    private List<String> extractPhoneme(int index, String syllable, List<String> syllables, List<String> fixed) {
        List<String> phonemes = new ArrayList<String>();

        if (syllable.length() == 1) {
            char first = syllable.charAt(0);

            if (Portuguese.isVowel(first)) {
                if (Portuguese.hasTilde(first)) {
                    phonemes.add(String.valueOf(first));
                } else {
                    phonemes.add(String.valueOf(Portuguese.rawVowel(first)));
                }
            }
            return phonemes;
        } else if (syllable.length() == 2) {

            if (syllable.charAt(0) == 'c') {
                // Check for digraph (xs)
                if (index > 0) {
                    String lastSyllable = syllables.get(index - 1);
                    char lastLetter = lastSyllable.charAt(lastSyllable.length() - 1);
                    if (lastLetter == 'x') {
                        fixed.remove(fixed.size() - 1);
                        phonemes.add(String.valueOf("xc"));
                        phonemes.add(String.valueOf(syllable.charAt(1)));
                        return phonemes;
                    }
                }

                char vowel = syllable.charAt(1);
                char rawVowel = Portuguese.rawVowel(vowel);
                if ('i' == rawVowel || 'e' == rawVowel) {
                    phonemes.add(String.valueOf("s"));
                    phonemes.add(String.valueOf(vowel));
                } else {
                    phonemes.add(String.valueOf("k"));
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                }
                return phonemes;
            } else if (syllable.charAt(0) == 'g') {
                char vowel = syllable.charAt(1);
                char rawVowel = Portuguese.rawVowel(vowel);
                if ('i' == rawVowel || 'e' == rawVowel) {
                    phonemes.add(String.valueOf("j"));
                    phonemes.add(String.valueOf(vowel));
                } else {
                    phonemes.add(String.valueOf("g"));
                    phonemes.add(String.valueOf(vowel));
                }
                return phonemes;
            } else if (syllable.charAt(0) == 'h') {
                phonemes.add(String.valueOf(syllable.charAt(1)));
                return phonemes;
            } else if (syllable.charAt(0) == 'r') {
                if (isFirstSyllable(index)) {
                    // Is first syllable?
                    phonemes.add("r'");
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                } else {
                    // Check for digraph
                    if (syllables.get(index - 1).endsWith("r")) {
                        fixed.remove(fixed.size() - 1);
                        phonemes.add("r'");
                    } else {
                        phonemes.add("r");
                    }
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                }

                return phonemes;
            } else if (syllable.charAt(0) == 's') {
                // Check last syllable
                if (index > 0) {
                    String lastSyllable = syllables.get(index - 1);
                    char lastLetter = lastSyllable.charAt(lastSyllable.length() - 1);
                    if (Portuguese.isVowel(lastLetter)) {
                        phonemes.add("z");
                        phonemes.add(String.valueOf(syllable.charAt(1)));
                        return phonemes;
                    } else if ('s' == lastLetter) {
                        // Digraph
                        phonemes.add(String.valueOf(syllable.charAt(1)));
                        return phonemes;
                    }
                }

            } else if (syllable.charAt(0) == 'x') {
                char vowel = syllable.charAt(1);
                char rawVowel = Portuguese.rawVowel(vowel);

                // Check last syllable
                if (index > 0) {
                    String lastSyllable = syllables.get(index - 1);
                    char lastLetter = lastSyllable.charAt(lastSyllable.length() - 1);

                    // Example: bru[xa], frou[xo]
                    if ('u' == lastLetter) {
                        // Example: flu[xo]
                        if ('l' == lastSyllable.charAt(lastSyllable.length() - 2)) {
                            phonemes.add(String.valueOf("ks"));
                            phonemes.add(String.valueOf(vowel));
                        } else {
                            phonemes.add(String.valueOf("ch"));
                            phonemes.add(String.valueOf(vowel));
                        }
                        return phonemes;
                        // Example: a[xi]la
                    } else if ("a".equals(lastSyllable)
                            // Example: ane[xo]
                            || "ne".equals(lastSyllable)
                            || "ve".equals(lastSyllable)
                            || Portuguese.isConsonantCluster(0, lastSyllable)) {
                        phonemes.add(String.valueOf("ks"));
                        phonemes.add(String.valueOf(vowel));
                        return phonemes;
                        // Example: e[xa]to, e[xa]me
                    } else if ("e".equals(lastSyllable)||"ê".equals(lastSyllable)) {
                        phonemes.add(String.valueOf("z"));
                        phonemes.add(String.valueOf(vowel));
                        return phonemes;
                        // Example en[xe]rido
                    } else if ('i' == lastLetter || 'n' == lastLetter) {
                        phonemes.add(String.valueOf("ch"));
                        phonemes.add(String.valueOf(vowel));
                        return phonemes;
                    }
                }

                // Example: xi, xo
                if (vowel == 'i' || vowel == 'o') {
                    phonemes.add("ks");
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    return phonemes;
                }
                // Example: me[xe], li[xo], ta[xa]
                else {
                    phonemes.add("ch");
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    return phonemes;
                }
            } else if (syllable.charAt(0) == 'w') {
                phonemes.add("u");
                phonemes.add(String.valueOf(syllable.charAt(1)));
                return phonemes;
            } else if (syllable.charAt(0) == 'ç') {
                phonemes.add("s");
                phonemes.add(String.valueOf(syllable.charAt(1)));
                return phonemes;
            }
        } else if (syllable.length() == 3) {
            // Digraphs
            if ((syllable.charAt(0) == 'c' && syllable.charAt(1) == 'h') ||
                    (syllable.charAt(0) == 'l' && syllable.charAt(1) == 'h') ||
                    (syllable.charAt(0) == 'n' && syllable.charAt(1) == 'h')) {
                phonemes.add(String.valueOf(syllable.charAt(0))+String.valueOf(syllable.charAt(1)));
                phonemes.add(String.valueOf(syllable.charAt(2)));
                return phonemes;
            } else if (syllable.charAt(0) == 'q') {
                char vowel = syllable.charAt(2);
                char rawVowel = Portuguese.rawVowel(vowel);

                if (rawVowel == 'a' || rawVowel == 'o') {
                    phonemes.add("k");
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    phonemes.add(String.valueOf(syllable.charAt(2)));
                } else {
                    phonemes.add("k");
                    phonemes.add(String.valueOf(syllable.charAt(2)));
                }
                return phonemes;

            } else if (syllable.charAt(0) == 'x') {

                // Example e[xer]cício
                if (index < syllables.size() - 2) {
                    phonemes.add(String.valueOf("z"));
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    phonemes.add(String.valueOf(syllable.charAt(2)));
                } else {
                    // Syllables starting with X
                    phonemes.add(String.valueOf("ch"));
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    phonemes.add(String.valueOf(syllable.charAt(2)));
                }
                return phonemes;
            } else if (syllable.charAt(2) == 'x') {
                // Syllables ending with X
                char vowel = Portuguese.rawVowel(syllable.charAt(1));
                // Example: [tex]to
                if (vowel == 'e') {
                    phonemes.add(String.valueOf(syllable.charAt(0)));
                    phonemes.add(String.valueOf(syllable.charAt(1)));
                    phonemes.add(String.valueOf("s"));
                    return phonemes;
                }
            }
        }

        // Default case
        for (int i = 0; i < syllable.length(); i++) {
            char c = syllable.charAt(i);
            phonemes.add(String.valueOf(c));
        }

        return phonemes;
    }

    private boolean isFirstSyllable(int index) {
        return index == 0;
    }

}

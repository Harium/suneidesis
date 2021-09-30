package com.harium.suneidesis.linguistic.portuguese;

import com.harium.suneidesis.linguistic.nlp.Hyphenator;

import java.util.ArrayList;
import java.util.List;

public class RuleBasedHyphenator implements Hyphenator {

    @Override
    public List<String> hyphenate(String word) {
        List<String> chunks = new ArrayList<String>();
        int index = 0;

        int joinLastChunk = Integer.MAX_VALUE;
        //String joinLastChunk = "";

        while (index < word.length()) {

            if (joinLastChunk < index) {
                String toJoin = chunks.get(joinLastChunk - 1);
                if (joinLastChunk < chunks.size()) {
                    String chunk = chunks.get(joinLastChunk);
                    chunks.set(joinLastChunk, toJoin + chunk);
                    chunks.remove(joinLastChunk - 1);
                    joinLastChunk = Integer.MAX_VALUE;
                } else {
                    joinLastChunk = index;
                }
            }

            if (Portuguese.isVowel(index, word)) {
                int count = Portuguese.vowelCount(index, word);
                String chunk = word.substring(index, index + count);

                if (Portuguese.isDiphthong(chunk) && Portuguese.isCrescentDiphthong(chunk)) {
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
                int count = Portuguese.vowelCount(index + 1, word);

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

                    if (Portuguese.isConsonantCluster(index, word)) {
                        int consonantClusterLength = 2;
                        int vowelCount = Portuguese.vowelCount(index + consonantClusterLength, word);
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

                    if (Portuguese.isTriphthong(vowelChunk)) {
                        if (Portuguese.isCrescentTriphthong(vowelChunk)) {
                            String chunk = word.substring(index, index + 3);
                            chunks.add(chunk);
                            index += 3;
                        } else if (Portuguese.hasTilde(word.charAt(index + 2))) {
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
                                chunk = word.substring(index + 2, index + 4);
                                chunks.add(chunk);
                                index += 4;
                            } else {
                                String chunk = word.substring(index, index + count + 1);
                                chunks.add(chunk);
                                index += count + 3;
                            }

                        }
                    } else if (Portuguese.isDiphthong(vowelChunk)) {
                        if (Portuguese.isDiphthongDigraphe(index, word) || !Portuguese.isCrescentDiphthong(vowelChunk)) {
                            if (word.length() > index + 4) {
                                // [moi]nho
                                if (word.charAt(index + 3) == 'n' && word.charAt(index + 4) == 'h') {
                                    String chunk = word.substring(index, index + count);
                                    chunks.add(chunk);
                                    chunk = word.substring(index + count, index + count + 1);
                                    chunks.add(chunk);
                                    index += count + 1;
                                    continue;
                                }
                            }

                            // Decrescent Diphthong
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

    private String lastChunk(List<String> chunks) {
        return chunks.get(chunks.size() - 1);
    }

}

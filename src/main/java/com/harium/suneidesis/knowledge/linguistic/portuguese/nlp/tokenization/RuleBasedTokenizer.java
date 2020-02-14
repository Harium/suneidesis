package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.tokenization;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.Tokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RuleBasedTokenizer implements Tokenizer {

    @Override
    public String[] tokenize(String sentence) {

        List<String> tokens = new ArrayList<>();
        List<String> postAdd = new ArrayList<>();

        String[] parts = sentence.split(" ");

        for (String part : parts) {
            part = handlePonctuation(part, postAdd);
            if (splitContractions(part, tokens)) {
                continue;
            }

            tokens.add(part);

            if (!postAdd.isEmpty()) {
                tokens.addAll(postAdd);
                postAdd.clear();
            }

        }

        String[] tokensArray = new String[tokens.size()];
        return tokens.toArray(tokensArray);
    }

    private String handlePonctuation(String part, List<String> tokens) {
        if (part.endsWith(",")) {
            tokens.add(",");
            return part.substring(0, part.length() - 1);
        } else if (part.endsWith(".")) {
            tokens.add(".");
            return part.substring(0, part.length() - 1);
        } else if (part.endsWith("!")) {
            tokens.add("!");
            return part.substring(0, part.length() - 1);
        } else if (part.endsWith("?")) {
            tokens.add("?");
            return part.substring(0, part.length() - 1);
        }

        return part;
    }

    private boolean splitContractions(String part, List<String> tokens) {

        if (splitContraction(tokens, part, "à", "a", "a")) {
            return true;
        } else if (splitContraction(tokens, part, "às", "a", "as")) {
            return true;
        } else if (splitContraction(tokens, part, "ao", "a", "o")) {
            return true;
        } else if (splitContraction(tokens, part, "aos", "a", "os")) {
            return true;
        } else if (splitContraction(tokens, part, "aonde", "a", "onde")) {
            return true;
        } else if (splitContraction(tokens, part, "àquela", "a", "aquela")) {
            return true;
        } else if (splitContraction(tokens, part, "àquelas", "a", "aquelas")) {
            return true;
        } else if (splitContraction(tokens, part, "àquele", "a", "aquele")) {
            return true;
        } else if (splitContraction(tokens, part, "àqueles", "a", "aqueles")) {
            return true;
        } else if (splitContraction(tokens, part, "àquilo", "a", "aquilo")) {
            return true;
        } else if (splitContraction(tokens, part, "comigo", "com", "mim")) {
            return true;
        } else if (splitContraction(tokens, part, "contigo", "com", "ti")) {
            return true;
        } /*else if (splitContraction(tokens, part, "consigo", "com", "si")) {
            return true;
        }*/ else if (splitContraction(tokens, "conosco", "com", "nós")) {
            return true;
        } else if (splitContraction(tokens, part, "da", "de", "a")) {
            return true;
        } else if (splitContraction(tokens, part, "das", "de", "as")) {
            return true;
        } else if (splitContraction(tokens, part, "do", "de", "o")) {
            return true;
        } else if (splitContraction(tokens, part, "dos", "de", "os")) {
            return true;
        } else if (splitContraction(tokens, part, "dum", "de", "um")) {
            return true;
        } else if (splitContraction(tokens, part, "duma", "de", "uma")) {
            return true;
        } else if (splitContraction(tokens, part, "daquela", "de", "aquela")) {
            return true;
        } else if (splitContraction(tokens, part, "daquelas", "de", "aquelas")) {
            return true;
        } else if (splitContraction(tokens, part, "daqui", "de", "aqui")) {
            return true;
        } else if (splitContraction(tokens, part, "daquilo", "de", "aquilo")) {
            return true;
        } else if (splitContraction(tokens, part, "dali", "de", "ali")) {
            return true;
        } else if (splitContraction(tokens, part, "daí", "de", "aí")) {
            return true;
        } else if (splitContraction(tokens, part, "dela", "de", "ela")) {
            return true;
        } else if (splitContraction(tokens, part, "delas", "de", "elas")) {
            return true;
        } else if (splitContraction(tokens, part, "dele", "de", "ele")) {
            return true;
        } else if (splitContraction(tokens, part, "deles", "de", "eles")) {
            return true;
        } else if (splitContraction(tokens, part, "desse", "de", "esse")) {
            return true;
        } else if (splitContraction(tokens, part, "dessa", "de", "essa")) {
            return true;
        } else if (splitContraction(tokens, part, "dessas", "de", "essas")) {
            return true;
        } else if (splitContraction(tokens, part, "desta", "de", "esta")) {
            return true;
        } else if (splitContraction(tokens, part, "destas", "de", "estas")) {
            return true;
        } else if (splitContraction(tokens, part, "desses", "de", "esses")) {
            return true;
        } else if (splitContraction(tokens, part, "deste", "de", "este")) {
            return true;
        } else if (splitContraction(tokens, part, "destes", "de", "estes")) {
            return true;
        } else if (splitContraction(tokens, part, "disso", "de", "isso")) {
            return true;
        } else if (splitContraction(tokens, part, "disto", "de", "isto")) {
            return true;
        } else if (splitContraction(tokens, part, "doutro", "de", "outro")) {
            return true;
        } else if (splitContraction(tokens, part, "doutros", "de", "outros")) {
            return true;
        } else if (splitContraction(tokens, part, "na", "em", "a")) {
            return true;
        } else if (splitContraction(tokens, part, "nas", "em", "as")) {
            return true;
        } else if (splitContraction(tokens, part, "no", "em", "o")) {
            return true;
        } else if (splitContraction(tokens, part, "nos", "em", "os")) {
            return true;
        } else if (splitContraction(tokens, part, "num", "em", "um")) {
            return true;
        } else if (splitContraction(tokens, part, "nuns", "em", "uns")) {
            return true;
        } else if (splitContraction(tokens, part, "numa", "em", "uma")) {
            return true;
        } else if (splitContraction(tokens, part, "numas", "em", "umas")) {
            return true;
        } else if (splitContraction(tokens, part, "naquela", "em", "aquela")) {
            return true;
        } else if (splitContraction(tokens, part, "naquelas", "em", "aquelas")) {
            return true;
        } else if (splitContraction(tokens, part, "naquele", "em", "aquele")) {
            return true;
        } else if (splitContraction(tokens, part, "naqueles", "em", "aqueles")) {
            return true;
        } else if (splitContraction(tokens, part, "naquilo", "em", "aquilo")) {
            return true;
        } else if (splitContraction(tokens, part, "nela", "em", "ela")) {
            return true;
        } else if (splitContraction(tokens, part, "nele", "em", "ele")) {
            return true;
        } else if (splitContraction(tokens, part, "nelas", "em", "elas")) {
            return true;
        } else if (splitContraction(tokens, part, "neles", "em", "eles")) {
            return true;
        } else if (splitContraction(tokens, part, "nessa", "em", "essa")) {
            return true;
        } else if (splitContraction(tokens, part, "nessas", "em", "essas")) {
            return true;
        } else if (splitContraction(tokens, part, "nesta", "em", "esta")) {
            return true;
        } else if (splitContraction(tokens, part, "nestas", "em", "estas")) {
            return true;
        } else if (splitContraction(tokens, part, "nisso", "em", "isso")) {
            return true;
        } else if (splitContraction(tokens, part, "nisso", "em", "isso")) {
            return true;
        } else if (splitContraction(tokens, part, "noutro", "em", "outro")) {
            return true;
        } else if (splitContraction(tokens, part, "noutros", "em", "outros")) {
            return true;
        } else if (splitContraction(tokens, part, "pela", "por", "a")) {
            return true;
        } else if (splitContraction(tokens, part, "pelas", "por", "as")) {
            return true;
        } else if (splitContraction(tokens, part, "pelo", "por", "o")) {
            return true;
        } else if (splitContraction(tokens, part, "pelos", "por", "os")) {
            return true;
        } else if (splitContraction(tokens, part, "pra", "para", "a")) {
            return true;
        } else if (splitContraction(tokens, part, "pras", "para", "as")) {
            return true;
        } else if (splitContraction(tokens, part, "pro", "para", "o")) {
            return true;
        } else if (splitContraction(tokens, part, "pros", "para", "os")) {
            return true;
        }

        return false;
    }

    private boolean splitContraction(List<String> tokens, String part, String root, String... contractions) {
        if (root.equalsIgnoreCase(part)) {
            tokens.addAll(Arrays.asList(contractions));
            return true;
        }
        return false;
    }

}

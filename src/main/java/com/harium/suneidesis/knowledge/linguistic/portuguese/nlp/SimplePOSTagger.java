package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.POSTaggerReconstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.POSTaggerReconstructor.*;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class SimplePOSTagger implements POSTagger {

    Map<String, String> words = new HashMap<>();
    Set<String> toBe = new HashSet<>();

    {
        addDeterminers();
        addPrepositions();
        addPronouns();
        addAdverbs();
        addVerbs();
        addConjuctions();
    }

    private void addDeterminers() {
        words.put("o", POSTaggerReconstructor.DETERMINER);
        words.put("a", POSTaggerReconstructor.DETERMINER);
        words.put("os", POSTaggerReconstructor.DETERMINER);
        words.put("as", POSTaggerReconstructor.DETERMINER);
        words.put("um", POSTaggerReconstructor.DETERMINER);
        words.put("uma", POSTaggerReconstructor.DETERMINER);
        words.put("uns", POSTaggerReconstructor.DETERMINER);
        words.put("umas", POSTaggerReconstructor.DETERMINER);
    }

    private void addPrepositions() {
        //words.put("a", POSTaggerReconstructor.PREPOSITION);
        words.put("à", POSTaggerReconstructor.PREPOSITION);
        words.put("ante", POSTaggerReconstructor.PREPOSITION);
        words.put("após", POSTaggerReconstructor.PREPOSITION);
        words.put("até", POSTaggerReconstructor.PREPOSITION);
        words.put("com", POSTaggerReconstructor.PREPOSITION);
        words.put("contra", POSTaggerReconstructor.PREPOSITION);
        words.put("de", POSTaggerReconstructor.PREPOSITION);
        // de + x
        words.put("da", POSTaggerReconstructor.PREPOSITION);
        words.put("do", POSTaggerReconstructor.PREPOSITION);
        words.put("desde", POSTaggerReconstructor.PREPOSITION);
        words.put("em", POSTaggerReconstructor.PREPOSITION);
        // em + x
        words.put("na", POSTaggerReconstructor.PREPOSITION);
        words.put("no", POSTaggerReconstructor.PREPOSITION);
        words.put("num", POSTaggerReconstructor.PREPOSITION);
        words.put("numa", POSTaggerReconstructor.PREPOSITION);
        words.put("numas", POSTaggerReconstructor.PREPOSITION);
        words.put("entre", POSTaggerReconstructor.PREPOSITION);
        words.put("para", POSTaggerReconstructor.PREPOSITION);
        words.put("perante", POSTaggerReconstructor.PREPOSITION);
        words.put("por", POSTaggerReconstructor.PREPOSITION);
        // por + x
        words.put("pela", POSTaggerReconstructor.PREPOSITION);
        words.put("pelo", POSTaggerReconstructor.PREPOSITION);
        words.put("pelas", POSTaggerReconstructor.PREPOSITION);
        words.put("pelos", POSTaggerReconstructor.PREPOSITION);
        words.put("sem", POSTaggerReconstructor.PREPOSITION);
        words.put("sob", POSTaggerReconstructor.PREPOSITION);
        words.put("sobre", POSTaggerReconstructor.PREPOSITION);
        words.put("trás", POSTaggerReconstructor.PREPOSITION);
    }

    private void addPronouns() {
        words.put("eu", PERSONAL_PRONOUN);
        words.put("tu", PERSONAL_PRONOUN);
        words.put("você", PERSONAL_PRONOUN);
        words.put("ele", PERSONAL_PRONOUN);
        words.put("ela", PERSONAL_PRONOUN);
        words.put("nós", PERSONAL_PRONOUN);
        words.put("vós", PERSONAL_PRONOUN);
        words.put("eles", PERSONAL_PRONOUN);
        words.put("elas", PERSONAL_PRONOUN);
    }

    private void addAdverbs() {
        words.put("sempre", ADVERB);
        words.put("muito", ADVERB);
    }

    private void addVerbs() {
        toBe.add("estou");
        toBe.add("é");
        toBe.add("és");
        toBe.add("somos");
        toBe.add("sou");

        for (String verb : toBe) {
            words.put(verb, VERB);
        }

        words.put("quero", VERB);
        words.put("queria", VERB);
        words.put("vou", VERB);
    }

    private void addConjuctions() {
        words.put("e", COORDINATING_CONJUCTION);
    }

    @Override
    public String[] posTag(String[] tokens) {
        String[] output = new String[tokens.length];

        boolean afterToBe = false;
        String lastToken = NOUN;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            if (words.containsKey(word)) {
                lastToken = words.get(word);
                output[i] = lastToken;
                if (VERB.equals(lastToken)) {
                    if (toBe.contains(word)) {
                        afterToBe = true;
                    } else {
                        afterToBe = false;
                    }
                }
            } else {
                if (afterToBe) {
                    output[i] = POSTaggerReconstructor.ADJECTIVE;
                } else {
                    output[i] = POSTaggerReconstructor.NOUN;
                }
            }
        }

        return output;
    }

}

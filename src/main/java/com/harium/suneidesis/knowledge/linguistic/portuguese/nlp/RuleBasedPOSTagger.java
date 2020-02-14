package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger implements POSTagger {

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

        words.put("me", PERSONAL_PRONOUN);
        words.put("mim", PERSONAL_PRONOUN);
        words.put("comigo", PERSONAL_PRONOUN);
        words.put("te", PERSONAL_PRONOUN);
        words.put("ti", PERSONAL_PRONOUN);
        words.put("contigo", PERSONAL_PRONOUN);
        //words.put("o", PERSONAL_PRONOUN);
        //words.put("a", PERSONAL_PRONOUN);
        words.put("lhe", PERSONAL_PRONOUN);
        words.put("se", PERSONAL_PRONOUN);
        words.put("si", PERSONAL_PRONOUN);
        words.put("consigo", PERSONAL_PRONOUN);
        words.put("conosco", PERSONAL_PRONOUN);
        words.put("convosco", PERSONAL_PRONOUN);
        //words.put("nos", PERSONAL_PRONOUN);
        words.put("vos", PERSONAL_PRONOUN);
    }

    private void addAdverbs() {
        words.put("sempre", ADVERB);
        words.put("nunca", ADVERB);
        words.put("muito", ADVERB);
        words.put("pouco", ADVERB);
        words.put("tão", ADVERB);

        // Time
        words.put("hoje", ADVERB);
        words.put("logo", ADVERB);
        words.put("primeiro", ADVERB);
        words.put("ontem", ADVERB);
        words.put("tarde", ADVERB);
        words.put("outrora", ADVERB);
        words.put("amanhã", ADVERB);
        words.put("cedo", ADVERB);
        words.put("dantes", ADVERB);
        words.put("depois", ADVERB);
        words.put("ainda", ADVERB);
        words.put("antigamente", ADVERB);
        words.put("antes", ADVERB);
        words.put("doravante", ADVERB);
        words.put("então", ADVERB);
        words.put("ora", ADVERB);
        words.put("jamais", ADVERB);
        words.put("agora", ADVERB);
        words.put("já", ADVERB);
        words.put("enfim", ADVERB);
        words.put("afinal", ADVERB);
        words.put("amiúde", ADVERB);
        words.put("breve", ADVERB);
        words.put("constantemente", ADVERB);
        words.put("entrementes", ADVERB);
        words.put("imediatamente", ADVERB);
        words.put("primeiramente", ADVERB);
        words.put("provisoriamente", ADVERB);
        words.put("sucessivamente", ADVERB);
        // Expressions
        //words.put("às vezes", ADVERB);
        //words.put("à tarde", ADVERB);
        //words.put("à noite", ADVERB);
        //words.put("de manhã", ADVERB);
        //words.put("de repente", ADVERB);
        //words.put("de vez em quando", ADVERB);
        //words.put("de quando em quando", ADVERB);
        //words.put("a qualquer momento", ADVERB);
        //words.put("de tempos em tempos", ADVERB);
        //words.put("em breve", ADVERB);
        //words.put("hoje em dia", ADVERB);


    }

    private void addVerbs() {
        toBe.add("estou");
        toBe.add("é");
        toBe.add("és");
        toBe.add("somos");
        toBe.add("sou");
        toBe.add("são");

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
        String lastToken = "NOUN";
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
                if(Character.isUpperCase(word.charAt(0))) {
                    // Name
                    output[i] = POSTaggerReconstructor.NOUN;
                } else if (afterToBe) {
                    output[i] = ADJECTIVE;
                } else if (lastToken.equals(POSTaggerReconstructor.ADVERB)) {
                    output[i] = ADJECTIVE;
                } else if (guessVerb(word)) {
                    output[i] = VERB;
                } else {
                    output[i] = POSTaggerReconstructor.NOUN;
                }
            }
        }

        return output;
    }

    private boolean guessVerb(String word) {
        if (word.endsWith("ar") || word.endsWith("er") || word.endsWith("ir")) {
            return true;
        }

        if (!word.endsWith("rão")) {

        }

        // Regular verbs
        if (word.endsWith("ai")
                || word.endsWith("am")
                || word.endsWith("amos")
                || word.endsWith("eis")
                || word.endsWith("rão")
                // Nasce
                || word.endsWith("sce")
                // Produz
                || word.endsWith("duz")) {
            return true;
        }

        return false;
    }

}

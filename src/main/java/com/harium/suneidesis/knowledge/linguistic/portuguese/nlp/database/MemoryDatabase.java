package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

public class MemoryDatabase implements WordDatabase {

    Map<String, List<String>> words = new HashMap<>();

    public MemoryDatabase() {
        addPunctuation();
        addDeterminers();
        addPrepositions();
        addPronouns();
        addAdverbs();
        addVerbs();
        addConjuctions();
    }

    @Override
    public List<String> getTags(String word) {
        return words.get(word);
    }

    private void addPunctuation() {
        add(".", POSTaggerReconstructor.PUNCTUATION);
        add(",", POSTaggerReconstructor.PUNCTUATION);
        add(":", POSTaggerReconstructor.PUNCTUATION);
        add(";", POSTaggerReconstructor.PUNCTUATION);
        add("!", POSTaggerReconstructor.PUNCTUATION);
        add("?", POSTaggerReconstructor.PUNCTUATION);
    }

    private void addDeterminers() {
        add("o", POSTaggerReconstructor.DETERMINER);
        add("a", POSTaggerReconstructor.DETERMINER);
        add("os", POSTaggerReconstructor.DETERMINER);
        add("as", POSTaggerReconstructor.DETERMINER);
        add("um", POSTaggerReconstructor.DETERMINER);
        add("uma", POSTaggerReconstructor.DETERMINER);
        add("uns", POSTaggerReconstructor.DETERMINER);
        add("umas", POSTaggerReconstructor.DETERMINER);
    }

    private void addPrepositions() {
        add("a", POSTaggerReconstructor.PREPOSITION);
        add("ante", POSTaggerReconstructor.PREPOSITION);
        add("após", POSTaggerReconstructor.PREPOSITION);
        add("até", POSTaggerReconstructor.PREPOSITION);
        add("com", POSTaggerReconstructor.PREPOSITION);
        add("contra", POSTaggerReconstructor.PREPOSITION);
        add("de", POSTaggerReconstructor.PREPOSITION);
        add("desde", POSTaggerReconstructor.PREPOSITION);
        add("em", POSTaggerReconstructor.PREPOSITION);
        add("entre", POSTaggerReconstructor.PREPOSITION);
        add("para", POSTaggerReconstructor.PREPOSITION);
        add("perante", POSTaggerReconstructor.PREPOSITION);
        add("por", POSTaggerReconstructor.PREPOSITION);
        add("sem", POSTaggerReconstructor.PREPOSITION);
        add("sob", POSTaggerReconstructor.PREPOSITION);
        add("sobre", POSTaggerReconstructor.PREPOSITION);
        add("trás", POSTaggerReconstructor.PREPOSITION);
    }

    private void addPronouns() {
        add("eu", PERSONAL_PRONOUN);
        add("tu", PERSONAL_PRONOUN);
        add("você", PERSONAL_PRONOUN);
        add("ele", PERSONAL_PRONOUN);
        add("ela", PERSONAL_PRONOUN);
        add("nós", PERSONAL_PRONOUN);
        add("vós", PERSONAL_PRONOUN);
        add("eles", PERSONAL_PRONOUN);
        add("elas", PERSONAL_PRONOUN);

        add("me", PERSONAL_PRONOUN);
        add("mim", PERSONAL_PRONOUN);
        add("comigo", PERSONAL_PRONOUN);
        add("te", PERSONAL_PRONOUN);
        add("ti", PERSONAL_PRONOUN);
        add("contigo", PERSONAL_PRONOUN);
        add("o", PERSONAL_PRONOUN);
        add("a", PERSONAL_PRONOUN);
        add("lhe", PERSONAL_PRONOUN);
        add("se", PERSONAL_PRONOUN);
        add("si", PERSONAL_PRONOUN);
        add("nos", PERSONAL_PRONOUN);
        add("vos", PERSONAL_PRONOUN);

        // Handled by tokenizer
        //add("consigo", PERSONAL_PRONOUN);
        //add("conosco", PERSONAL_PRONOUN);
        //add("convosco", PERSONAL_PRONOUN);

        // Interrogative
        add("quem", WH_PRONOUN);
    }

    private void addAdverbs() {
        add("sempre", ADVERB);
        add("nunca", ADVERB);
        add("muito", ADVERB);
        add("pouco", ADVERB);
        add("tão", ADVERB);

        // Time
        add("hoje", ADVERB);
        add("logo", ADVERB);
        add("primeiro", ADVERB);
        add("ontem", ADVERB);
        add("tarde", ADVERB);
        add("outrora", ADVERB);
        add("amanhã", ADVERB);
        add("cedo", ADVERB);
        add("dantes", ADVERB);
        add("depois", ADVERB);
        add("ainda", ADVERB);
        add("antigamente", ADVERB);
        add("antes", ADVERB);
        add("doravante", ADVERB);
        add("então", ADVERB);
        add("ora", ADVERB);
        add("jamais", ADVERB);
        add("agora", ADVERB);
        add("já", ADVERB);
        add("enfim", ADVERB);
        add("afinal", ADVERB);
        add("amiúde", ADVERB);
        add("breve", ADVERB);
        add("constantemente", ADVERB);
        add("entrementes", ADVERB);
        add("imediatamente", ADVERB);
        add("primeiramente", ADVERB);
        add("provisoriamente", ADVERB);
        add("sucessivamente", ADVERB);
        // Expressions
        //add("às vezes", ADVERB);
        //add("à tarde", ADVERB);
        //add("à noite", ADVERB);
        //add("de manhã", ADVERB);
        //add("de repente", ADVERB);
        //add("de vez em quando", ADVERB);
        //add("de quando em quando", ADVERB);
        //add("a qualquer momento", ADVERB);
        //add("de tempos em tempos", ADVERB);
        //add("em breve", ADVERB);
        //add("hoje em dia", ADVERB);
    }

    private void addVerbs() {
        // To be
        add("estou", VERB);
        add("é", VERB);
        add("és", VERB);
        add("somos", VERB);
        add("sou", VERB);
        add("são", VERB);
        add("será", VERB);

        add("quero", VERB);
        add("queria", VERB);
        add("vou", VERB);

        // First Conjugation
        addRegularVerb("amar");
        addRegularVerb("cantar");
        addRegularVerb("falar");
        // Second Conjugation
        addRegularVerb("beber");
        addRegularVerb("comer");
        addRegularVerb("correr");
        addRegularVerb("viver");
        // Third Conjugation
        addRegularVerb("partir");
        addRegularVerb("ferir");
        addRegularVerb("produzir");
    }

    private void addRegularVerb(String verb) {
        // Another approach would be comparing the begining of a word with radicals
        //String radical = verb.substring(0, verb.length() - 2);
        //radicalVerbs.add(radical);

        if (verb.endsWith("ar")) {
            addFirstConjugation(verb);
        } else if (verb.endsWith("er")) {
            addSecondConjugation(verb);
        } else if (verb.endsWith("ir")) {
            addThirdConjugation(verb);
        }
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-primeira-conjugacao-terminados-em-ar/
     * @param verb
     */
    private void addFirstConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        add(radical + "ar", VERB);
        add(radical + "ado", VERB);
        add(radical + "ando", VERB);

        // Present
        add(radical + "o", VERB);
        add(radical + "as", VERB);
        add(radical + "a", VERB);
        add(radical + "amos", VERB);
        add(radical + "ais", VERB);
        add(radical + "am", VERB);
        // Past Perfect
        add(radical + "ei", VERB);
        add(radical + "aste", VERB);
        add(radical + "ou", VERB);
        //add(radical + "amos", VERB);
        add(radical + "astes", VERB);
        add(radical + "aram", VERB);
        // Past Imperfect
        add(radical + "ava", VERB);
        add(radical + "avas", VERB);
        //add(radical + "ava", VERB);
        add(radical + "ávamos", VERB);
        add(radical + "áveis", VERB);
        add(radical + "avam", VERB);
        // Past more than perfect
        add(radical + "ara", VERB);
        add(radical + "aras", VERB);
        //add(radical + "ara", VERB);
        add(radical + "áramos", VERB);
        add(radical + "áreis", VERB);
        add(radical + "aram", VERB);
        // Present Future
        add(radical + "arei", VERB);
        add(radical + "arás", VERB);
        add(radical + "ará", VERB);
        add(radical + "aremos", VERB);
        add(radical + "areis", VERB);
        add(radical + "arão", VERB);
        // Past Future
        add(radical + "aria", VERB);
        add(radical + "arias", VERB);
        //add(radical + "aria", VERB);
        add(radical + "aríamos", VERB);
        add(radical + "aríeis", VERB);
        add(radical + "ariam", VERB);
        // Subjunctive Mood
        // Present
        add(radical + "e", VERB);
        add(radical + "es", VERB);
        add(radical + "e", VERB);
        add(radical + "emos", VERB);
        add(radical + "eis", VERB);
        add(radical + "em", VERB);
        // Past Imperfect
        add(radical + "asse", VERB);
        add(radical + "asses", VERB);
        //add(radical + "asse", VERB);
        add(radical + "ássemos", VERB);
        add(radical + "ásseis", VERB);
        add(radical + "assem", VERB);
        // Future
        //add(radical + "ar", VERB);
        add(radical + "ares", VERB);
        //add(radical + "ar", VERB);
        add(radical + "armos", VERB);
        add(radical + "ardes", VERB);
        add(radical + "arem", VERB);
        // Imperative
        // Affirmative
        //add(radical + "--", VERB);
        //add(radical + "a", VERB);
        //add(radical + "e", VERB);
        //add(radical + "emos", VERB);
        add(radical + "ai", VERB);
        //add(radical + "em", VERB);
        // Negative
        //add(radical + "--", VERB);
        //add(radical + "es", VERB);
        //add(radical + "e", VERB);
        //add(radical + "emos", VERB);
        //add(radical + "eis", VERB);
        //add(radical + "em", VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-segunda-conjugacao-terminados-em-er/
     * @param verb
     */
    private void addSecondConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        add(radical + "er", VERB);
        add(radical + "ido", VERB);
        add(radical + "endo", VERB);

        // Present
        add(radical + "o", VERB);
        add(radical + "es", VERB);
        add(radical + "e", VERB);
        add(radical + "emos", VERB);
        add(radical + "eis", VERB);
        add(radical + "em", VERB);
        // Past Perfect
        add(radical + "i", VERB);
        add(radical + "este", VERB);
        add(radical + "eu", VERB);
        //add(radical + "emos", VERB);
        add(radical + "estes", VERB);
        add(radical + "eram", VERB);
        // Past Imperfect
        add(radical + "ia", VERB);
        add(radical + "ias", VERB);
        //add(radical + "ia", VERB);
        add(radical + "íamos", VERB);
        add(radical + "íeis", VERB);
        add(radical + "iam", VERB);
        // Past more than perfect
        add(radical + "era", VERB);
        add(radical + "eras", VERB);
        //add(radical + "era", VERB);
        add(radical + "éramos", VERB);
        add(radical + "êreis", VERB);
        add(radical + "eram", VERB);
        // Present Future
        add(radical + "erei", VERB);
        add(radical + "erás", VERB);
        add(radical + "erá", VERB);
        add(radical + "eremos", VERB);
        add(radical + "ereis", VERB);
        add(radical + "erão", VERB);
        // Past Future
        add(radical + "eria", VERB);
        add(radical + "erias", VERB);
        //add(radical + "eria", VERB);
        add(radical + "eríamos", VERB);
        add(radical + "eríeis", VERB);
        add(radical + "eriam", VERB);
        // Subjunctive Mood
        // Present
        add(radical + "a", VERB);
        add(radical + "as", VERB);
        add(radical + "a", VERB);
        add(radical + "amos", VERB);
        add(radical + "ais", VERB);
        add(radical + "am", VERB);
        // Past Imperfect
        add(radical + "esse", VERB);
        add(radical + "esses", VERB);
        //add(radical + "esse", VERB);
        add(radical + "êssemos", VERB);
        add(radical + "êsseis", VERB);
        add(radical + "essem", VERB);
        // Future
        //add(radical + "er", VERB);
        add(radical + "eres", VERB);
        //add(radical + "er", VERB);
        add(radical + "ermos", VERB);
        add(radical + "erdes", VERB);
        add(radical + "erem", VERB);
        // Imperative
        // Affirmative
        //add(radical + "--", VERB);
        //add(radical + "e", VERB);
        //add(radical + "a", VERB);
        //add(radical + "amos", VERB);
        add(radical + "ei", VERB);
        //add(radical + "am", VERB);
        // Negative
        //add(radical + "--", VERB);
        //add(radical + "as", VERB);
        //add(radical + "a", VERB);
        //add(radical + "amos", VERB);
        //add(radical + "ais", VERB);
        //add(radical + "am", VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-terceira-conjugacao-terminados-em-ir/
     * @param verb
     */
    private void addThirdConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        add(radical + "ir", VERB);
        add(radical + "ido", VERB);
        add(radical + "indo", VERB);

        // Present
        add(radical + "o", VERB);
        add(radical + "es", VERB);
        add(radical + "e", VERB);
        add(radical + "imos", VERB);
        add(radical + "is", VERB);
        add(radical + "em", VERB);
        // Past Perfect
        add(radical + "i", VERB);
        add(radical + "iste", VERB);
        add(radical + "iu", VERB);
        //add(radical + "imos", VERB);
        add(radical + "istes", VERB);
        add(radical + "iram", VERB);
        // Past Imperfect
        add(radical + "ia", VERB);
        add(radical + "ias", VERB);
        //add(radical + "ia", VERB);
        add(radical + "íamos", VERB);
        add(radical + "íeis", VERB);
        add(radical + "iam", VERB);
        // Past more than perfect
        add(radical + "ira", VERB);
        add(radical + "iras", VERB);
        //add(radical + "ira", VERB);
        add(radical + "íramos", VERB);
        add(radical + "íreis", VERB);
        add(radical + "iram", VERB);
        // Present Future
        add(radical + "irei", VERB);
        add(radical + "irás", VERB);
        add(radical + "irá", VERB);
        add(radical + "iremos", VERB);
        add(radical + "ireis", VERB);
        add(radical + "irão", VERB);
        // Past Future
        add(radical + "iria", VERB);
        add(radical + "irias", VERB);
        //add(radical + "iria", VERB);
        add(radical + "iríamos", VERB);
        add(radical + "iríeis", VERB);
        add(radical + "iriam", VERB);
        // Subjunctive Mood
        // Present
        add(radical + "a", VERB);
        add(radical + "as", VERB);
        add(radical + "a", VERB);
        add(radical + "amos", VERB);
        add(radical + "ais", VERB);
        add(radical + "am", VERB);
        // Past Imperfect
        add(radical + "isse", VERB);
        add(radical + "isses", VERB);
        //add(radical + "isse", VERB);
        add(radical + "íssemos", VERB);
        add(radical + "ísseis", VERB);
        add(radical + "issem", VERB);
        // Future
        //add(radical + "ir", VERB);
        add(radical + "ires", VERB);
        //add(radical + "ir", VERB);
        add(radical + "irmos", VERB);
        add(radical + "irdes", VERB);
        add(radical + "irem", VERB);
        // Imperative
        // Affirmative
        //add(radical + "--", VERB);
        //add(radical + "e", VERB);
        //add(radical + "a", VERB);
        //add(radical + "amos", VERB);
        add(radical + "i", VERB);
        //add(radical + "am", VERB);
        // Negative
        //add(radical + "--", VERB);
        //add(radical + "as", VERB);
        //add(radical + "a", VERB);
        //add(radical + "amos", VERB);
        //add(radical + "ais", VERB);
        //add(radical + "am", VERB);
    }

    private void addConjuctions() {
        add("e", COORDINATING_CONJUCTION);
    }

    private void add(String word, String tag) {
        List<String> tags = words.computeIfAbsent(word, k -> new ArrayList<>());
        tags.add(tag);
    }

}

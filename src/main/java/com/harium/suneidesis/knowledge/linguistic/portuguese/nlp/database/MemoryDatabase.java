package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

public class MemoryDatabase implements WordDatabase {

    Map<String, List<String>> words = new HashMap<>();
    Map<String, Verb> verbs = new HashMap<>();

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

    @Override
    public Verb getVerb(String verb) {
        return verbs.get(verb);
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
        addVerb("é", "ser", VERB);
        addVerb("és", "ser", VERB);
        addVerb("somos", "ser", VERB);
        addVerb("sou", "ser", VERB);
        addVerb("são", "ser", VERB);
        addVerb("será", "ser", VERB);

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
     *
     * @param verb
     */
    private void addFirstConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "ado", verb, VERB);
        addVerb(radical + "ando", verb, VERB);

        // Present
        addVerb(radical + "o", verb, VERB);
        addVerb(radical + "as", verb, VERB);
        addVerb(radical + "a", verb, VERB);
        addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ais", verb, VERB);
        addVerb(radical + "am", verb, VERB);
        // Past Perfect
        addVerb(radical + "ei", verb, VERB);
        addVerb(radical + "aste", verb, VERB);
        addVerb(radical + "ou", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "astes", verb, VERB);
        addVerb(radical + "aram", verb, VERB);
        // Past Imperfect
        addVerb(radical + "ava", verb, VERB);
        addVerb(radical + "avas", verb, VERB);
        //addVerb(radical + "ava", verb, VERB);
        addVerb(radical + "ávamos", verb, VERB);
        addVerb(radical + "áveis", verb, VERB);
        addVerb(radical + "avam", verb, VERB);
        // Past more than perfect
        addVerb(radical + "ara", verb, VERB);
        addVerb(radical + "aras", verb, VERB);
        //addVerb(radical + "ara", verb, VERB);
        addVerb(radical + "áramos", verb, VERB);
        addVerb(radical + "áreis", verb, VERB);
        addVerb(radical + "aram", verb, VERB);
        // Present Future
        addVerb(radical + "arei", verb, VERB);
        addVerb(radical + "arás", verb, VERB);
        addVerb(radical + "ará", verb, VERB);
        addVerb(radical + "aremos", verb, VERB);
        addVerb(radical + "areis", verb, VERB);
        addVerb(radical + "arão", verb, VERB);
        // Past Future
        addVerb(radical + "aria", verb, VERB);
        addVerb(radical + "arias", verb, VERB);
        //addVerb(radical + "aria", verb, VERB);
        addVerb(radical + "aríamos", verb, VERB);
        addVerb(radical + "aríeis", verb, VERB);
        addVerb(radical + "ariam", verb, VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "e", verb, VERB);
        addVerb(radical + "es", verb, VERB);
        addVerb(radical + "e", verb, VERB);
        addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "eis", verb, VERB);
        addVerb(radical + "em", verb, VERB);
        // Past Imperfect
        addVerb(radical + "asse", verb, VERB);
        addVerb(radical + "asses", verb, VERB);
        //addVerb(radical + "asse", verb, VERB);
        addVerb(radical + "ássemos", verb, VERB);
        addVerb(radical + "ásseis", verb, VERB);
        addVerb(radical + "assem", verb, VERB);
        // Future
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "ares", verb, VERB);
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "armos", verb, VERB);
        addVerb(radical + "ardes", verb, VERB);
        addVerb(radical + "arem", verb, VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "ai", verb, VERB);
        //addVerb(radical + "em", verb, VERB);
        // Negative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "es", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "emos", verb, VERB);
        //addVerb(radical + "eis", verb, VERB);
        //addVerb(radical + "em", verb, VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-segunda-conjugacao-terminados-em-er/
     *
     * @param verb
     */
    private void addSecondConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        addVerb(radical + "er", verb, VERB);
        addVerb(radical + "ido", verb, VERB);
        addVerb(radical + "endo", verb, VERB);

        // Present
        addVerb(radical + "o", verb, VERB);
        addVerb(radical + "es", verb, VERB);
        addVerb(radical + "e", verb, VERB);
        addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "eis", verb, VERB);
        addVerb(radical + "em", verb, VERB);
        // Past Perfect
        addVerb(radical + "i", verb, VERB);
        addVerb(radical + "este", verb, VERB);
        addVerb(radical + "eu", verb, VERB);
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "estes", verb, VERB);
        addVerb(radical + "eram", verb, VERB);
        // Past Imperfect
        addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "ias", verb, VERB);
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, VERB);
        addVerb(radical + "íeis", verb, VERB);
        addVerb(radical + "iam", verb, VERB);
        // Past more than perfect
        addVerb(radical + "era", verb, VERB);
        addVerb(radical + "eras", verb, VERB);
        //addVerb(radical + "era", verb, VERB);
        addVerb(radical + "éramos", verb, VERB);
        addVerb(radical + "êreis", verb, VERB);
        addVerb(radical + "eram", verb, VERB);
        // Present Future
        addVerb(radical + "erei", verb, VERB);
        addVerb(radical + "erás", verb, VERB);
        addVerb(radical + "erá", verb, VERB);
        addVerb(radical + "eremos", verb, VERB);
        addVerb(radical + "ereis", verb, VERB);
        addVerb(radical + "erão", verb, VERB);
        // Past Future
        addVerb(radical + "eria", verb, VERB);
        addVerb(radical + "erias", verb, VERB);
        //addVerb(radical + "eria", verb, VERB);
        addVerb(radical + "eríamos", verb, VERB);
        addVerb(radical + "eríeis", verb, VERB);
        addVerb(radical + "eriam", verb, VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, VERB);
        addVerb(radical + "as", verb, VERB);
        addVerb(radical + "a", verb, VERB);
        addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ais", verb, VERB);
        addVerb(radical + "am", verb, VERB);
        // Past Imperfect
        addVerb(radical + "esse", verb, VERB);
        addVerb(radical + "esses", verb, VERB);
        //addVerb(radical + "esse", verb, VERB);
        addVerb(radical + "êssemos", verb, VERB);
        addVerb(radical + "êsseis", verb, VERB);
        addVerb(radical + "essem", verb, VERB);
        // Future
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "eres", verb, VERB);
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "ermos", verb, VERB);
        addVerb(radical + "erdes", verb, VERB);
        addVerb(radical + "erem", verb, VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ei", verb, VERB);
        //addVerb(radical + "am", verb, VERB);
        // Negative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "as", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        //addVerb(radical + "ais", verb, VERB);
        //addVerb(radical + "am", verb, VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-terceira-conjugacao-terminados-em-ir/
     *
     * @param verb
     */
    private void addThirdConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "ido", verb, VERB);
        addVerb(radical + "indo", verb, VERB);

        // Present
        addVerb(radical + "o", verb, VERB);
        addVerb(radical + "es", verb, VERB);
        addVerb(radical + "e", verb, VERB);
        addVerb(radical + "imos", verb, VERB);
        addVerb(radical + "is", verb, VERB);
        addVerb(radical + "em", verb, VERB);
        // Past Perfect
        addVerb(radical + "i", verb, VERB);
        addVerb(radical + "iste", verb, VERB);
        addVerb(radical + "iu", verb, VERB);
        //addVerb(radical + "imos", verb, VERB);
        addVerb(radical + "istes", verb, VERB);
        addVerb(radical + "iram", verb, VERB);
        // Past Imperfect
        addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "ias", verb, VERB);
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, VERB);
        addVerb(radical + "íeis", verb, VERB);
        addVerb(radical + "iam", verb, VERB);
        // Past more than perfect
        addVerb(radical + "ira", verb, VERB);
        addVerb(radical + "iras", verb, VERB);
        //addVerb(radical + "ira", verb, VERB);
        addVerb(radical + "íramos", verb, VERB);
        addVerb(radical + "íreis", verb, VERB);
        addVerb(radical + "iram", verb, VERB);
        // Present Future
        addVerb(radical + "irei", verb, VERB);
        addVerb(radical + "irás", verb, VERB);
        addVerb(radical + "irá", verb, VERB);
        addVerb(radical + "iremos", verb, VERB);
        addVerb(radical + "ireis", verb, VERB);
        addVerb(radical + "irão", verb, VERB);
        // Past Future
        addVerb(radical + "iria", verb, VERB);
        addVerb(radical + "irias", verb, VERB);
        //addVerb(radical + "iria", verb, VERB);
        addVerb(radical + "iríamos", verb, VERB);
        addVerb(radical + "iríeis", verb, VERB);
        addVerb(radical + "iriam", verb, VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, VERB);
        addVerb(radical + "as", verb, VERB);
        addVerb(radical + "a", verb, VERB);
        addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ais", verb, VERB);
        addVerb(radical + "am", verb, VERB);
        // Past Imperfect
        addVerb(radical + "isse", verb, VERB);
        addVerb(radical + "isses", verb, VERB);
        //addVerb(radical + "isse", verb, VERB);
        addVerb(radical + "íssemos", verb, VERB);
        addVerb(radical + "ísseis", verb, VERB);
        addVerb(radical + "issem", verb, VERB);
        // Future
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "ires", verb, VERB);
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "irmos", verb, VERB);
        addVerb(radical + "irdes", verb, VERB);
        addVerb(radical + "irem", verb, VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "i", verb, VERB);
        //addVerb(radical + "am", verb, VERB);
        // Negative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "as", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        //addVerb(radical + "ais", verb, VERB);
        //addVerb(radical + "am", verb, VERB);
    }

    private void addConjuctions() {
        add("e", COORDINATING_CONJUCTION);
    }

    private void addVerb(String word, String lemma, String tag) {
        List<String> tags = words.computeIfAbsent(word, k -> new ArrayList<>());
        tags.add(tag);

        Verb v = new Verb(lemma);
        verbs.put(word, v);
    }

    private void add(String word, String tag) {
        List<String> tags = words.computeIfAbsent(word, k -> new ArrayList<>());
        tags.add(tag);
    }

}

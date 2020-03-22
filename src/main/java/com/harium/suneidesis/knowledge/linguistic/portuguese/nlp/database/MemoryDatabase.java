package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDatabase implements WordDatabase {

    Map<String, List<Tag>> words = new HashMap<>();
    Map<String, Integer> wordIds = new HashMap<>();
    Map<String, Verb> verbs = new HashMap<>();

    public MemoryDatabase() {
        addPunctuation();
        addDeterminers();
        addPrepositions();
        addPronouns();
        addAdverbs();
        addVerbs();
        addConjuctions();
        addNumerals();
    }

    @Override
    public long getId(String word) {
        return wordIds.get(word);
    }

    @Override
    public List<Tag> getTags(String word) {
        return words.get(word);
    }

    @Override
    public Verb getVerb(String verb) {
        return verbs.get(verb);
    }

    private void addPunctuation() {
        add(".", Tag.PUNCTUATION);
        add(",", Tag.PUNCTUATION);
        add(":", Tag.PUNCTUATION);
        add(";", Tag.PUNCTUATION);
        add("!", Tag.PUNCTUATION);
        add("?", Tag.PUNCTUATION);
    }

    private void addDeterminers() {
        add("o", Tag.DETERMINER);
        add("a", Tag.DETERMINER);
        add("os", Tag.DETERMINER);
        add("as", Tag.DETERMINER);
        add("um", Tag.DETERMINER);
        add("uma", Tag.DETERMINER);
        add("uns", Tag.DETERMINER);
        add("umas", Tag.DETERMINER);
    }

    private void addPrepositions() {
        add("a", Tag.PREPOSITION);
        add("ante", Tag.PREPOSITION);
        add("após", Tag.PREPOSITION);
        add("até", Tag.PREPOSITION);
        add("com", Tag.PREPOSITION);
        add("contra", Tag.PREPOSITION);
        add("de", Tag.PREPOSITION);
        add("desde", Tag.PREPOSITION);
        add("em", Tag.PREPOSITION);
        add("entre", Tag.PREPOSITION);
        add("para", Tag.PREPOSITION);
        add("perante", Tag.PREPOSITION);
        add("por", Tag.PREPOSITION);
        add("sem", Tag.PREPOSITION);
        add("sob", Tag.PREPOSITION);
        add("sobre", Tag.PREPOSITION);
        add("trás", Tag.PREPOSITION);
    }

    private void addPronouns() {
        add("eu", Tag.PERSONAL_PRONOUN);
        add("tu", Tag.PERSONAL_PRONOUN);
        add("você", Tag.PERSONAL_PRONOUN);
        add("ele", Tag.PERSONAL_PRONOUN);
        add("ela", Tag.PERSONAL_PRONOUN);
        add("nós", Tag.PERSONAL_PRONOUN);
        add("vós", Tag.PERSONAL_PRONOUN);
        add("eles", Tag.PERSONAL_PRONOUN);
        add("elas", Tag.PERSONAL_PRONOUN);

        add("me", Tag.PERSONAL_PRONOUN);
        add("mim", Tag.PERSONAL_PRONOUN);
        add("comigo", Tag.PERSONAL_PRONOUN);
        add("te", Tag.PERSONAL_PRONOUN);
        add("ti", Tag.PERSONAL_PRONOUN);
        add("contigo", Tag.PERSONAL_PRONOUN);
        add("o", Tag.PERSONAL_PRONOUN);
        add("a", Tag.PERSONAL_PRONOUN);
        add("lhe", Tag.PERSONAL_PRONOUN);
        add("se", Tag.PERSONAL_PRONOUN);
        add("si", Tag.PERSONAL_PRONOUN);
        add("nos", Tag.PERSONAL_PRONOUN);
        add("vos", Tag.PERSONAL_PRONOUN);

        // Handled by tokenizer
        //add("consigo", PERSONAL_PRONOUN);
        //add("conosco", PERSONAL_PRONOUN);
        //add("convosco", PERSONAL_PRONOUN);

        // Interrogative
        add("quem", Tag.WH_PRONOUN);
    }

    private void addAdverbs() {
        add("sempre", Tag.ADVERB);
        add("nunca", Tag.ADVERB);
        add("muito", Tag.ADVERB);
        add("pouco", Tag.ADVERB);
        add("tão", Tag.ADVERB);

        // Time
        add("hoje", Tag.ADVERB);
        add("logo", Tag.ADVERB);
        add("primeiro", Tag.ADVERB);
        add("ontem", Tag.ADVERB);
        add("tarde", Tag.ADVERB);
        add("outrora", Tag.ADVERB);
        add("amanhã", Tag.ADVERB);
        add("cedo", Tag.ADVERB);
        add("dantes", Tag.ADVERB);
        add("depois", Tag.ADVERB);
        add("ainda", Tag.ADVERB);
        add("antigamente", Tag.ADVERB);
        add("antes", Tag.ADVERB);
        add("doravante", Tag.ADVERB);
        add("então", Tag.ADVERB);
        add("ora", Tag.ADVERB);
        add("jamais", Tag.ADVERB);
        add("agora", Tag.ADVERB);
        add("já", Tag.ADVERB);
        add("enfim", Tag.ADVERB);
        add("afinal", Tag.ADVERB);
        add("amiúde", Tag.ADVERB);
        add("breve", Tag.ADVERB);
        add("constantemente", Tag.ADVERB);
        add("entrementes", Tag.ADVERB);
        add("imediatamente", Tag.ADVERB);
        add("primeiramente", Tag.ADVERB);
        add("provisoriamente", Tag.ADVERB);
        add("sucessivamente", Tag.ADVERB);
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
        add("estou", Tag.VERB);
        addVerb("é", "ser", Tag.VERB);
        addVerb("és", "ser", Tag.VERB);
        addVerb("somos", "ser", Tag.VERB);
        addVerb("sou", "ser", Tag.VERB);
        addVerb("são", "ser", Tag.VERB);
        addVerb("será", "ser", Tag.VERB);

        add("quero", Tag.VERB);
        add("queria", Tag.VERB);
        add("vou", Tag.VERB);

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
        addVerb(radical + "ar", verb, Tag.VERB);
        addVerb(radical + "ado", verb, Tag.VERB);
        addVerb(radical + "ando", verb, Tag.VERB);

        // Present
        addVerb(radical + "o", verb, Tag.VERB);
        addVerb(radical + "as", verb, Tag.VERB);
        addVerb(radical + "a", verb, Tag.VERB);
        addVerb(radical + "amos", verb, Tag.VERB);
        addVerb(radical + "ais", verb, Tag.VERB);
        addVerb(radical + "am", verb, Tag.VERB);
        // Past Perfect
        addVerb(radical + "ei", verb, Tag.VERB);
        addVerb(radical + "aste", verb, Tag.VERB);
        addVerb(radical + "ou", verb, Tag.VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "astes", verb, Tag.VERB);
        addVerb(radical + "aram", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "ava", verb, Tag.VERB);
        addVerb(radical + "avas", verb, Tag.VERB);
        //addVerb(radical + "ava", verb, VERB);
        addVerb(radical + "ávamos", verb, Tag.VERB);
        addVerb(radical + "áveis", verb, Tag.VERB);
        addVerb(radical + "avam", verb, Tag.VERB);
        // Past more than perfect
        addVerb(radical + "ara", verb, Tag.VERB);
        addVerb(radical + "aras", verb, Tag.VERB);
        //addVerb(radical + "ara", verb, VERB);
        addVerb(radical + "áramos", verb, Tag.VERB);
        addVerb(radical + "áreis", verb, Tag.VERB);
        addVerb(radical + "aram", verb, Tag.VERB);
        // Present Future
        addVerb(radical + "arei", verb, Tag.VERB);
        addVerb(radical + "arás", verb, Tag.VERB);
        addVerb(radical + "ará", verb, Tag.VERB);
        addVerb(radical + "aremos", verb, Tag.VERB);
        addVerb(radical + "areis", verb, Tag.VERB);
        addVerb(radical + "arão", verb, Tag.VERB);
        // Past Future
        addVerb(radical + "aria", verb, Tag.VERB);
        addVerb(radical + "arias", verb, Tag.VERB);
        //addVerb(radical + "aria", verb, VERB);
        addVerb(radical + "aríamos", verb, Tag.VERB);
        addVerb(radical + "aríeis", verb, Tag.VERB);
        addVerb(radical + "ariam", verb, Tag.VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "e", verb, Tag.VERB);
        addVerb(radical + "es", verb, Tag.VERB);
        addVerb(radical + "e", verb, Tag.VERB);
        addVerb(radical + "emos", verb, Tag.VERB);
        addVerb(radical + "eis", verb, Tag.VERB);
        addVerb(radical + "em", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "asse", verb, Tag.VERB);
        addVerb(radical + "asses", verb, Tag.VERB);
        //addVerb(radical + "asse", verb, VERB);
        addVerb(radical + "ássemos", verb, Tag.VERB);
        addVerb(radical + "ásseis", verb, Tag.VERB);
        addVerb(radical + "assem", verb, Tag.VERB);
        // Future
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "ares", verb, Tag.VERB);
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "armos", verb, Tag.VERB);
        addVerb(radical + "ardes", verb, Tag.VERB);
        addVerb(radical + "arem", verb, Tag.VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "ai", verb, Tag.VERB);
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
        addVerb(radical + "er", verb, Tag.VERB);
        addVerb(radical + "ido", verb, Tag.VERB);
        addVerb(radical + "endo", verb, Tag.VERB);

        // Present
        addVerb(radical + "o", verb, Tag.VERB);
        addVerb(radical + "es", verb, Tag.VERB);
        addVerb(radical + "e", verb, Tag.VERB);
        addVerb(radical + "emos", verb, Tag.VERB);
        addVerb(radical + "eis", verb, Tag.VERB);
        addVerb(radical + "em", verb, Tag.VERB);
        // Past Perfect
        addVerb(radical + "i", verb, Tag.VERB);
        addVerb(radical + "este", verb, Tag.VERB);
        addVerb(radical + "eu", verb, Tag.VERB);
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "estes", verb, Tag.VERB);
        addVerb(radical + "eram", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "ia", verb, Tag.VERB);
        addVerb(radical + "ias", verb, Tag.VERB);
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, Tag.VERB);
        addVerb(radical + "íeis", verb, Tag.VERB);
        addVerb(radical + "iam", verb, Tag.VERB);
        // Past more than perfect
        addVerb(radical + "era", verb, Tag.VERB);
        addVerb(radical + "eras", verb, Tag.VERB);
        //addVerb(radical + "era", verb, VERB);
        addVerb(radical + "éramos", verb, Tag.VERB);
        addVerb(radical + "êreis", verb, Tag.VERB);
        addVerb(radical + "eram", verb, Tag.VERB);
        // Present Future
        addVerb(radical + "erei", verb, Tag.VERB);
        addVerb(radical + "erás", verb, Tag.VERB);
        addVerb(radical + "erá", verb, Tag.VERB);
        addVerb(radical + "eremos", verb, Tag.VERB);
        addVerb(radical + "ereis", verb, Tag.VERB);
        addVerb(radical + "erão", verb, Tag.VERB);
        // Past Future
        addVerb(radical + "eria", verb, Tag.VERB);
        addVerb(radical + "erias", verb, Tag.VERB);
        //addVerb(radical + "eria", verb, VERB);
        addVerb(radical + "eríamos", verb, Tag.VERB);
        addVerb(radical + "eríeis", verb, Tag.VERB);
        addVerb(radical + "eriam", verb, Tag.VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, Tag.VERB);
        addVerb(radical + "as", verb, Tag.VERB);
        addVerb(radical + "a", verb, Tag.VERB);
        addVerb(radical + "amos", verb, Tag.VERB);
        addVerb(radical + "ais", verb, Tag.VERB);
        addVerb(radical + "am", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "esse", verb, Tag.VERB);
        addVerb(radical + "esses", verb, Tag.VERB);
        //addVerb(radical + "esse", verb, VERB);
        addVerb(radical + "êssemos", verb, Tag.VERB);
        addVerb(radical + "êsseis", verb, Tag.VERB);
        addVerb(radical + "essem", verb, Tag.VERB);
        // Future
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "eres", verb, Tag.VERB);
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "ermos", verb, Tag.VERB);
        addVerb(radical + "erdes", verb, Tag.VERB);
        addVerb(radical + "erem", verb, Tag.VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ei", verb, Tag.VERB);
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
        addVerb(radical + "ir", verb, Tag.VERB);
        addVerb(radical + "ido", verb, Tag.VERB);
        addVerb(radical + "indo", verb, Tag.VERB);

        // Present
        addVerb(radical + "o", verb, Tag.VERB);
        addVerb(radical + "es", verb, Tag.VERB);
        addVerb(radical + "e", verb, Tag.VERB);
        addVerb(radical + "imos", verb, Tag.VERB);
        addVerb(radical + "is", verb, Tag.VERB);
        addVerb(radical + "em", verb, Tag.VERB);
        // Past Perfect
        addVerb(radical + "i", verb, Tag.VERB);
        addVerb(radical + "iste", verb, Tag.VERB);
        addVerb(radical + "iu", verb, Tag.VERB);
        //addVerb(radical + "imos", verb, VERB);
        addVerb(radical + "istes", verb, Tag.VERB);
        addVerb(radical + "iram", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "ia", verb, Tag.VERB);
        addVerb(radical + "ias", verb, Tag.VERB);
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, Tag.VERB);
        addVerb(radical + "íeis", verb, Tag.VERB);
        addVerb(radical + "iam", verb, Tag.VERB);
        // Past more than perfect
        addVerb(radical + "ira", verb, Tag.VERB);
        addVerb(radical + "iras", verb, Tag.VERB);
        //addVerb(radical + "ira", verb, VERB);
        addVerb(radical + "íramos", verb, Tag.VERB);
        addVerb(radical + "íreis", verb, Tag.VERB);
        addVerb(radical + "iram", verb, Tag.VERB);
        // Present Future
        addVerb(radical + "irei", verb, Tag.VERB);
        addVerb(radical + "irás", verb, Tag.VERB);
        addVerb(radical + "irá", verb, Tag.VERB);
        addVerb(radical + "iremos", verb, Tag.VERB);
        addVerb(radical + "ireis", verb, Tag.VERB);
        addVerb(radical + "irão", verb, Tag.VERB);
        // Past Future
        addVerb(radical + "iria", verb, Tag.VERB);
        addVerb(radical + "irias", verb, Tag.VERB);
        //addVerb(radical + "iria", verb, VERB);
        addVerb(radical + "iríamos", verb, Tag.VERB);
        addVerb(radical + "iríeis", verb, Tag.VERB);
        addVerb(radical + "iriam", verb, Tag.VERB);
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, Tag.VERB);
        addVerb(radical + "as", verb, Tag.VERB);
        addVerb(radical + "a", verb, Tag.VERB);
        addVerb(radical + "amos", verb, Tag.VERB);
        addVerb(radical + "ais", verb, Tag.VERB);
        addVerb(radical + "am", verb, Tag.VERB);
        // Past Imperfect
        addVerb(radical + "isse", verb, Tag.VERB);
        addVerb(radical + "isses", verb, Tag.VERB);
        //addVerb(radical + "isse", verb, VERB);
        addVerb(radical + "íssemos", verb, Tag.VERB);
        addVerb(radical + "ísseis", verb, Tag.VERB);
        addVerb(radical + "issem", verb, Tag.VERB);
        // Future
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "ires", verb, Tag.VERB);
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "irmos", verb, Tag.VERB);
        addVerb(radical + "irdes", verb, Tag.VERB);
        addVerb(radical + "irem", verb, Tag.VERB);
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "i", verb, Tag.VERB);
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
        add("e", Tag.COORDINATING_CONJUCTION);
    }

    private void addNumerals() {
        add("0", Tag.NUMERAL);
        add("1", Tag.NUMERAL);
        add("2", Tag.NUMERAL);
        add("3", Tag.NUMERAL);
        add("4", Tag.NUMERAL);
        add("5", Tag.NUMERAL);
        add("6", Tag.NUMERAL);
        add("7", Tag.NUMERAL);
        add("8", Tag.NUMERAL);
        add("9", Tag.NUMERAL);

        // Roman
        add("I", Tag.NUMERAL);
        add("II", Tag.NUMERAL);
        add("III", Tag.NUMERAL);
    }

    private void addVerb(String word, String lemma, Tag tag) {
        List<Tag> tags = words.computeIfAbsent(word, k -> new ArrayList<>());
        tags.add(tag);

        if (!wordIds.containsKey(lemma)) {
           add(lemma, Tag.VERB);
        }
        Verb v = new Verb(wordIds.get(lemma));
        verbs.put(word, v);
    }

    private void add(String word, Tag tag) {
        List<Tag> tags = words.computeIfAbsent(word, k -> new ArrayList<>());
        tags.add(tag);
        wordIds.put(word, wordIds.size());
    }

}

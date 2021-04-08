package com.harium.suneidesis.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class MemoryWordBase extends com.harium.suneidesis.linguistic.storage.MemoryWordBase {

    public MemoryWordBase() {
        this("");
    }

    public MemoryWordBase(String name) {
        super(name);
        addPunctuation();
        addDeterminers();
        addPrepositions();
        addPronouns();
        addAdverbs();
        addVerbs();
        addConjuctions();
        addNumerals();
    }

    private void addPunctuation() {
        addWord(".", Tag.PUNCTUATION);
        addWord(",", Tag.PUNCTUATION);
        addWord(":", Tag.PUNCTUATION);
        addWord(";", Tag.PUNCTUATION);
        addWord("!", Tag.PUNCTUATION);
        addWord("?", Tag.PUNCTUATION);
    }

    private void addDeterminers() {
        addWord("o", Tag.DETERMINER);
        addWord("a", Tag.DETERMINER);
        addWord("os", Tag.DETERMINER);
        addWord("as", Tag.DETERMINER);
        addWord("um", Tag.DETERMINER);
        addWord("uma", Tag.DETERMINER);
        addWord("uns", Tag.DETERMINER);
        addWord("umas", Tag.DETERMINER);
    }

    private void addPrepositions() {
        addWord("a", Tag.PREPOSITION);
        addWord("ante", Tag.PREPOSITION);
        addWord("após", Tag.PREPOSITION);
        addWord("até", Tag.PREPOSITION);
        addWord("com", Tag.PREPOSITION);
        addWord("contra", Tag.PREPOSITION);
        addWord("de", Tag.PREPOSITION);
        addWord("desde", Tag.PREPOSITION);
        addWord("em", Tag.PREPOSITION);
        addWord("entre", Tag.PREPOSITION);
        addWord("para", Tag.PREPOSITION);
        addWord("perante", Tag.PREPOSITION);
        addWord("por", Tag.PREPOSITION);
        addWord("sem", Tag.PREPOSITION);
        addWord("sob", Tag.PREPOSITION);
        addWord("sobre", Tag.PREPOSITION);
        addWord("trás", Tag.PREPOSITION);
    }

    private void addPronouns() {
        addWord("eu", Tag.PERSONAL_PRONOUN);
        addWord("tu", Tag.PERSONAL_PRONOUN);
        addWord("você", Tag.PERSONAL_PRONOUN);
        addWord("ele", Tag.PERSONAL_PRONOUN);
        addWord("ela", Tag.PERSONAL_PRONOUN);
        addWord("nós", Tag.PERSONAL_PRONOUN);
        addWord("vós", Tag.PERSONAL_PRONOUN);
        addWord("eles", Tag.PERSONAL_PRONOUN);
        addWord("elas", Tag.PERSONAL_PRONOUN);

        addWord("me", Tag.PERSONAL_PRONOUN);
        addWord("mim", Tag.PERSONAL_PRONOUN);
        addWord("comigo", Tag.PERSONAL_PRONOUN);
        addWord("te", Tag.PERSONAL_PRONOUN);
        addWord("ti", Tag.PERSONAL_PRONOUN);
        addWord("contigo", Tag.PERSONAL_PRONOUN);
        addWord("o", Tag.PERSONAL_PRONOUN);
        addWord("a", Tag.PERSONAL_PRONOUN);
        addWord("lhe", Tag.PERSONAL_PRONOUN);
        addWord("se", Tag.PERSONAL_PRONOUN);
        addWord("si", Tag.PERSONAL_PRONOUN);
        addWord("nos", Tag.PERSONAL_PRONOUN);
        addWord("vos", Tag.PERSONAL_PRONOUN);

        // Handled by tokenizer
        //addWord("consigo", PERSONAL_PRONOUN);
        //addWord("conosco", PERSONAL_PRONOUN);
        //addWord("convosco", PERSONAL_PRONOUN);

        // Interrogative
        addWord("quem", Tag.WH_PRONOUN);
    }

    private void addAdverbs() {
        addWord("sempre", Tag.ADVERB);
        addWord("nunca", Tag.ADVERB);
        addWord("muito", Tag.ADVERB);
        addWord("pouco", Tag.ADVERB);
        addWord("tão", Tag.ADVERB);

        // Time
        addWord("hoje", Tag.ADVERB);
        addWord("logo", Tag.ADVERB);
        addWord("primeiro", Tag.ADVERB);
        addWord("ontem", Tag.ADVERB);
        addWord("tarde", Tag.ADVERB);
        addWord("outrora", Tag.ADVERB);
        addWord("amanhã", Tag.ADVERB);
        addWord("cedo", Tag.ADVERB);
        addWord("dantes", Tag.ADVERB);
        addWord("depois", Tag.ADVERB);
        addWord("ainda", Tag.ADVERB);
        addWord("antigamente", Tag.ADVERB);
        addWord("antes", Tag.ADVERB);
        addWord("doravante", Tag.ADVERB);
        addWord("então", Tag.ADVERB);
        addWord("ora", Tag.ADVERB);
        addWord("jamais", Tag.ADVERB);
        addWord("agora", Tag.ADVERB);
        addWord("já", Tag.ADVERB);
        addWord("enfim", Tag.ADVERB);
        addWord("afinal", Tag.ADVERB);
        addWord("amiúde", Tag.ADVERB);
        addWord("breve", Tag.ADVERB);
        addWord("constantemente", Tag.ADVERB);
        addWord("entrementes", Tag.ADVERB);
        addWord("imediatamente", Tag.ADVERB);
        addWord("primeiramente", Tag.ADVERB);
        addWord("provisoriamente", Tag.ADVERB);
        addWord("sucessivamente", Tag.ADVERB);
        // Expressions
        //addWord("às vezes", ADVERB);
        //addWord("à tarde", ADVERB);
        //addWord("à noite", ADVERB);
        //addWord("de manhã", ADVERB);
        //addWord("de repente", ADVERB);
        //addWord("de vez em quando", ADVERB);
        //addWord("de quando em quando", ADVERB);
        //addWord("a qualquer momento", ADVERB);
        //addWord("de tempos em tempos", ADVERB);
        //addWord("em breve", ADVERB);
        //addWord("hoje em dia", ADVERB);
    }

    private void addVerbs() {
        // To be
        addWord("estou", Tag.VERB);
        addVerb("ser", "ser", Tag.VERB);
        addVerb("é", "ser", Tag.VERB);
        addVerb("és", "ser", Tag.VERB);
        addVerb("somos", "ser", Tag.VERB);
        addVerb("sou", "ser", Tag.VERB);
        addVerb("são", "ser", Tag.VERB);
        addVerb("será", "ser", Tag.VERB);

        addWord("quero", Tag.VERB);
        addWord("queria", Tag.VERB);
        addWord("vou", Tag.VERB);

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
        addWord("e", Tag.COORDINATING_CONJUCTION);
    }

    private void addNumerals() {
        addWord("0", Tag.NUMERAL);
        addWord("1", Tag.NUMERAL);
        addWord("2", Tag.NUMERAL);
        addWord("3", Tag.NUMERAL);
        addWord("4", Tag.NUMERAL);
        addWord("5", Tag.NUMERAL);
        addWord("6", Tag.NUMERAL);
        addWord("7", Tag.NUMERAL);
        addWord("8", Tag.NUMERAL);
        addWord("9", Tag.NUMERAL);

        // Roman
        addWord("I", Tag.NUMERAL);
        addWord("II", Tag.NUMERAL);
        addWord("III", Tag.NUMERAL);
    }
}

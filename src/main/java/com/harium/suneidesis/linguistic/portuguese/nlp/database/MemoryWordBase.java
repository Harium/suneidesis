package com.harium.suneidesis.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class MemoryWordBase extends com.harium.suneidesis.linguistic.repository.MemoryWordBase {

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
        addWord(".", Tag.PUNCTUATION.name());
        addWord(",", Tag.PUNCTUATION.name());
        addWord(":", Tag.PUNCTUATION.name());
        addWord(";", Tag.PUNCTUATION.name());
        addWord("!", Tag.PUNCTUATION.name());
        addWord("?", Tag.PUNCTUATION.name());
    }

    private void addDeterminers() {
        addWord("o", Tag.DETERMINER.name());
        addWord("a", Tag.DETERMINER.name());
        addWord("os", Tag.DETERMINER.name());
        addWord("as", Tag.DETERMINER.name());
        addWord("um", Tag.DETERMINER.name());
        addWord("uma", Tag.DETERMINER.name());
        addWord("uns", Tag.DETERMINER.name());
        addWord("umas", Tag.DETERMINER.name());
    }

    private void addPrepositions() {
        addWord("a", Tag.PREPOSITION.name());
        addWord("ante", Tag.PREPOSITION.name());
        addWord("após", Tag.PREPOSITION.name());
        addWord("até", Tag.PREPOSITION.name());
        addWord("com", Tag.PREPOSITION.name());
        addWord("contra", Tag.PREPOSITION.name());
        addWord("de", Tag.PREPOSITION.name());
        addWord("desde", Tag.PREPOSITION.name());
        addWord("em", Tag.PREPOSITION.name());
        addWord("entre", Tag.PREPOSITION.name());
        addWord("para", Tag.PREPOSITION.name());
        addWord("perante", Tag.PREPOSITION.name());
        addWord("por", Tag.PREPOSITION.name());
        addWord("sem", Tag.PREPOSITION.name());
        addWord("sob", Tag.PREPOSITION.name());
        addWord("sobre", Tag.PREPOSITION.name());
        addWord("trás", Tag.PREPOSITION.name());
    }

    private void addPronouns() {
        addWord("eu", Tag.PERSONAL_PRONOUN.name());
        addWord("tu", Tag.PERSONAL_PRONOUN.name());
        addWord("você", Tag.PERSONAL_PRONOUN.name());
        addWord("ele", Tag.PERSONAL_PRONOUN.name());
        addWord("ela", Tag.PERSONAL_PRONOUN.name());
        addWord("nós", Tag.PERSONAL_PRONOUN.name());
        addWord("vós", Tag.PERSONAL_PRONOUN.name());
        addWord("eles", Tag.PERSONAL_PRONOUN.name());
        addWord("elas", Tag.PERSONAL_PRONOUN.name());

        addWord("me", Tag.PERSONAL_PRONOUN.name());
        addWord("mim", Tag.PERSONAL_PRONOUN.name());
        addWord("comigo", Tag.PERSONAL_PRONOUN.name());
        addWord("te", Tag.PERSONAL_PRONOUN.name());
        addWord("ti", Tag.PERSONAL_PRONOUN.name());
        addWord("contigo", Tag.PERSONAL_PRONOUN.name());
        addWord("o", Tag.PERSONAL_PRONOUN.name());
        addWord("a", Tag.PERSONAL_PRONOUN.name());
        addWord("lhe", Tag.PERSONAL_PRONOUN.name());
        addWord("se", Tag.PERSONAL_PRONOUN.name());
        addWord("si", Tag.PERSONAL_PRONOUN.name());
        addWord("nos", Tag.PERSONAL_PRONOUN.name());
        addWord("vos", Tag.PERSONAL_PRONOUN.name());

        // Handled by tokenizer
        //addWord("consigo", Tag.PERSONAL_PRONOUN.name());
        //addWord("conosco", Tag.PERSONAL_PRONOUN.name());
        //addWord("convosco", Tag.PERSONAL_PRONOUN.name());

        // Interrogative
        addWord("quem", Tag.WH_PRONOUN.name());
    }

    private void addAdverbs() {
        addWord("sempre", Tag.ADVERB.name());
        addWord("nunca", Tag.ADVERB.name());
        addWord("muito", Tag.ADVERB.name());
        addWord("pouco", Tag.ADVERB.name());
        addWord("tão", Tag.ADVERB.name());

        // Time
        addWord("hoje", Tag.ADVERB.name());
        addWord("logo", Tag.ADVERB.name());
        addWord("primeiro", Tag.ADVERB.name());
        addWord("ontem", Tag.ADVERB.name());
        addWord("tarde", Tag.ADVERB.name());
        addWord("outrora", Tag.ADVERB.name());
        addWord("amanhã", Tag.ADVERB.name());
        addWord("cedo", Tag.ADVERB.name());
        addWord("dantes", Tag.ADVERB.name());
        addWord("depois", Tag.ADVERB.name());
        addWord("ainda", Tag.ADVERB.name());
        addWord("antigamente", Tag.ADVERB.name());
        addWord("antes", Tag.ADVERB.name());
        addWord("doravante", Tag.ADVERB.name());
        addWord("então", Tag.ADVERB.name());
        addWord("ora", Tag.ADVERB.name());
        addWord("jamais", Tag.ADVERB.name());
        addWord("agora", Tag.ADVERB.name());
        addWord("já", Tag.ADVERB.name());
        addWord("enfim", Tag.ADVERB.name());
        addWord("afinal", Tag.ADVERB.name());
        addWord("amiúde", Tag.ADVERB.name());
        addWord("breve", Tag.ADVERB.name());
        addWord("constantemente", Tag.ADVERB.name());
        addWord("entrementes", Tag.ADVERB.name());
        addWord("imediatamente", Tag.ADVERB.name());
        addWord("primeiramente", Tag.ADVERB.name());
        addWord("provisoriamente", Tag.ADVERB.name());
        addWord("sucessivamente", Tag.ADVERB.name());
        // Expressions
        //addWord("as vezes", Tag.ADVERB.name());
        //addWord("a tarde", Tag.ADVERB.name());
        //addWord("a noite", Tag.ADVERB.name());
        //addWord("de manhã", Tag.ADVERB.name());
        //addWord("de repente", Tag.ADVERB.name());
        //addWord("de vez em quando", Tag.ADVERB.name());
        //addWord("de quando em quando", Tag.ADVERB.name());
        //addWord("a qualquer momento", Tag.ADVERB.name());
        //addWord("de tempos em tempos", Tag.ADVERB.name());
        //addWord("em breve", Tag.ADVERB.name());
        //addWord("hoje em dia", Tag.ADVERB.name());
    }

    private void addVerbs() {
        // To be
        addWord("estou", Tag.VERB.name());
        addVerb("ser", "ser", Tag.VERB.name());
        addVerb("é", "ser", Tag.VERB.name());
        addVerb("és", "ser", Tag.VERB.name());
        addVerb("somos", "ser", Tag.VERB.name());
        addVerb("sou", "ser", Tag.VERB.name());
        addVerb("são", "ser", Tag.VERB.name());
        addVerb("será", "ser", Tag.VERB.name());

        addWord("quero", Tag.VERB.name());
        addWord("queria", Tag.VERB.name());
        addWord("vou", Tag.VERB.name());

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
        addVerb(radical + "ar", verb, Tag.VERB.name());
        addVerb(radical + "ado", verb, Tag.VERB.name());
        addVerb(radical + "ando", verb, Tag.VERB.name());

        // Present
        addVerb(radical + "o", verb, Tag.VERB.name());
        addVerb(radical + "as", verb, Tag.VERB.name());
        addVerb(radical + "a", verb, Tag.VERB.name());
        addVerb(radical + "amos", verb, Tag.VERB.name());
        addVerb(radical + "ais", verb, Tag.VERB.name());
        addVerb(radical + "am", verb, Tag.VERB.name());
        // Past Perfect
        addVerb(radical + "ei", verb, Tag.VERB.name());
        addVerb(radical + "aste", verb, Tag.VERB.name());
        addVerb(radical + "ou", verb, Tag.VERB.name());
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "astes", verb, Tag.VERB.name());
        addVerb(radical + "aram", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "ava", verb, Tag.VERB.name());
        addVerb(radical + "avas", verb, Tag.VERB.name());
        //addVerb(radical + "ava", verb, VERB);
        addVerb(radical + "ávamos", verb, Tag.VERB.name());
        addVerb(radical + "áveis", verb, Tag.VERB.name());
        addVerb(radical + "avam", verb, Tag.VERB.name());
        // Past more than perfect
        addVerb(radical + "ara", verb, Tag.VERB.name());
        addVerb(radical + "aras", verb, Tag.VERB.name());
        //addVerb(radical + "ara", verb, VERB);
        addVerb(radical + "áramos", verb, Tag.VERB.name());
        addVerb(radical + "áreis", verb, Tag.VERB.name());
        addVerb(radical + "aram", verb, Tag.VERB.name());
        // Present Future
        addVerb(radical + "arei", verb, Tag.VERB.name());
        addVerb(radical + "arás", verb, Tag.VERB.name());
        addVerb(radical + "ará", verb, Tag.VERB.name());
        addVerb(radical + "aremos", verb, Tag.VERB.name());
        addVerb(radical + "areis", verb, Tag.VERB.name());
        addVerb(radical + "arão", verb, Tag.VERB.name());
        // Past Future
        addVerb(radical + "aria", verb, Tag.VERB.name());
        addVerb(radical + "arias", verb, Tag.VERB.name());
        //addVerb(radical + "aria", verb, VERB);
        addVerb(radical + "aríamos", verb, Tag.VERB.name());
        addVerb(radical + "aríeis", verb, Tag.VERB.name());
        addVerb(radical + "ariam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addVerb(radical + "e", verb, Tag.VERB.name());
        addVerb(radical + "es", verb, Tag.VERB.name());
        addVerb(radical + "e", verb, Tag.VERB.name());
        addVerb(radical + "emos", verb, Tag.VERB.name());
        addVerb(radical + "eis", verb, Tag.VERB.name());
        addVerb(radical + "em", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "asse", verb, Tag.VERB.name());
        addVerb(radical + "asses", verb, Tag.VERB.name());
        //addVerb(radical + "asse", verb, VERB);
        addVerb(radical + "ássemos", verb, Tag.VERB.name());
        addVerb(radical + "ásseis", verb, Tag.VERB.name());
        addVerb(radical + "assem", verb, Tag.VERB.name());
        // Future
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "ares", verb, Tag.VERB.name());
        //addVerb(radical + "ar", verb, VERB);
        addVerb(radical + "armos", verb, Tag.VERB.name());
        addVerb(radical + "ardes", verb, Tag.VERB.name());
        addVerb(radical + "arem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "ai", verb, Tag.VERB.name());
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
        addVerb(radical + "er", verb, Tag.VERB.name());
        addVerb(radical + "ido", verb, Tag.VERB.name());
        addVerb(radical + "endo", verb, Tag.VERB.name());

        // Present
        addVerb(radical + "o", verb, Tag.VERB.name());
        addVerb(radical + "es", verb, Tag.VERB.name());
        addVerb(radical + "e", verb, Tag.VERB.name());
        addVerb(radical + "emos", verb, Tag.VERB.name());
        addVerb(radical + "eis", verb, Tag.VERB.name());
        addVerb(radical + "em", verb, Tag.VERB.name());
        // Past Perfect
        addVerb(radical + "i", verb, Tag.VERB.name());
        addVerb(radical + "este", verb, Tag.VERB.name());
        addVerb(radical + "eu", verb, Tag.VERB.name());
        //addVerb(radical + "emos", verb, VERB);
        addVerb(radical + "estes", verb, Tag.VERB.name());
        addVerb(radical + "eram", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "ia", verb, Tag.VERB.name());
        addVerb(radical + "ias", verb, Tag.VERB.name());
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, Tag.VERB.name());
        addVerb(radical + "íeis", verb, Tag.VERB.name());
        addVerb(radical + "iam", verb, Tag.VERB.name());
        // Past more than perfect
        addVerb(radical + "era", verb, Tag.VERB.name());
        addVerb(radical + "eras", verb, Tag.VERB.name());
        //addVerb(radical + "era", verb, VERB);
        addVerb(radical + "éramos", verb, Tag.VERB.name());
        addVerb(radical + "êreis", verb, Tag.VERB.name());
        addVerb(radical + "eram", verb, Tag.VERB.name());
        // Present Future
        addVerb(radical + "erei", verb, Tag.VERB.name());
        addVerb(radical + "erás", verb, Tag.VERB.name());
        addVerb(radical + "erá", verb, Tag.VERB.name());
        addVerb(radical + "eremos", verb, Tag.VERB.name());
        addVerb(radical + "ereis", verb, Tag.VERB.name());
        addVerb(radical + "erão", verb, Tag.VERB.name());
        // Past Future
        addVerb(radical + "eria", verb, Tag.VERB.name());
        addVerb(radical + "erias", verb, Tag.VERB.name());
        //addVerb(radical + "eria", verb, VERB);
        addVerb(radical + "eríamos", verb, Tag.VERB.name());
        addVerb(radical + "eríeis", verb, Tag.VERB.name());
        addVerb(radical + "eriam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, Tag.VERB.name());
        addVerb(radical + "as", verb, Tag.VERB.name());
        addVerb(radical + "a", verb, Tag.VERB.name());
        addVerb(radical + "amos", verb, Tag.VERB.name());
        addVerb(radical + "ais", verb, Tag.VERB.name());
        addVerb(radical + "am", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "esse", verb, Tag.VERB.name());
        addVerb(radical + "esses", verb, Tag.VERB.name());
        //addVerb(radical + "esse", verb, VERB);
        addVerb(radical + "êssemos", verb, Tag.VERB.name());
        addVerb(radical + "êsseis", verb, Tag.VERB.name());
        addVerb(radical + "essem", verb, Tag.VERB.name());
        // Future
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "eres", verb, Tag.VERB.name());
        //addVerb(radical + "er", verb, VERB);
        addVerb(radical + "ermos", verb, Tag.VERB.name());
        addVerb(radical + "erdes", verb, Tag.VERB.name());
        addVerb(radical + "erem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "ei", verb, Tag.VERB.name());
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
        addVerb(radical + "ir", verb, Tag.VERB.name());
        addVerb(radical + "ido", verb, Tag.VERB.name());
        addVerb(radical + "indo", verb, Tag.VERB.name());

        // Present
        addVerb(radical + "o", verb, Tag.VERB.name());
        addVerb(radical + "es", verb, Tag.VERB.name());
        addVerb(radical + "e", verb, Tag.VERB.name());
        addVerb(radical + "imos", verb, Tag.VERB.name());
        addVerb(radical + "is", verb, Tag.VERB.name());
        addVerb(radical + "em", verb, Tag.VERB.name());
        // Past Perfect
        addVerb(radical + "i", verb, Tag.VERB.name());
        addVerb(radical + "iste", verb, Tag.VERB.name());
        addVerb(radical + "iu", verb, Tag.VERB.name());
        //addVerb(radical + "imos", verb, VERB);
        addVerb(radical + "istes", verb, Tag.VERB.name());
        addVerb(radical + "iram", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "ia", verb, Tag.VERB.name());
        addVerb(radical + "ias", verb, Tag.VERB.name());
        //addVerb(radical + "ia", verb, VERB);
        addVerb(radical + "íamos", verb, Tag.VERB.name());
        addVerb(radical + "íeis", verb, Tag.VERB.name());
        addVerb(radical + "iam", verb, Tag.VERB.name());
        // Past more than perfect
        addVerb(radical + "ira", verb, Tag.VERB.name());
        addVerb(radical + "iras", verb, Tag.VERB.name());
        //addVerb(radical + "ira", verb, VERB);
        addVerb(radical + "íramos", verb, Tag.VERB.name());
        addVerb(radical + "íreis", verb, Tag.VERB.name());
        addVerb(radical + "iram", verb, Tag.VERB.name());
        // Present Future
        addVerb(radical + "irei", verb, Tag.VERB.name());
        addVerb(radical + "irás", verb, Tag.VERB.name());
        addVerb(radical + "irá", verb, Tag.VERB.name());
        addVerb(radical + "iremos", verb, Tag.VERB.name());
        addVerb(radical + "ireis", verb, Tag.VERB.name());
        addVerb(radical + "irão", verb, Tag.VERB.name());
        // Past Future
        addVerb(radical + "iria", verb, Tag.VERB.name());
        addVerb(radical + "irias", verb, Tag.VERB.name());
        //addVerb(radical + "iria", verb, VERB);
        addVerb(radical + "iríamos", verb, Tag.VERB.name());
        addVerb(radical + "iríeis", verb, Tag.VERB.name());
        addVerb(radical + "iriam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addVerb(radical + "a", verb, Tag.VERB.name());
        addVerb(radical + "as", verb, Tag.VERB.name());
        addVerb(radical + "a", verb, Tag.VERB.name());
        addVerb(radical + "amos", verb, Tag.VERB.name());
        addVerb(radical + "ais", verb, Tag.VERB.name());
        addVerb(radical + "am", verb, Tag.VERB.name());
        // Past Imperfect
        addVerb(radical + "isse", verb, Tag.VERB.name());
        addVerb(radical + "isses", verb, Tag.VERB.name());
        //addVerb(radical + "isse", verb, VERB);
        addVerb(radical + "íssemos", verb, Tag.VERB.name());
        addVerb(radical + "ísseis", verb, Tag.VERB.name());
        addVerb(radical + "issem", verb, Tag.VERB.name());
        // Future
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "ires", verb, Tag.VERB.name());
        //addVerb(radical + "ir", verb, VERB);
        addVerb(radical + "irmos", verb, Tag.VERB.name());
        addVerb(radical + "irdes", verb, Tag.VERB.name());
        addVerb(radical + "irem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addVerb(radical + "--", verb, VERB);
        //addVerb(radical + "e", verb, VERB);
        //addVerb(radical + "a", verb, VERB);
        //addVerb(radical + "amos", verb, VERB);
        addVerb(radical + "i", verb, Tag.VERB.name());
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
        addWord("e", Tag.COORDINATING_CONJUCTION.name());
    }

    private void addNumerals() {
        addWord("0", Tag.NUMERAL.name());
        addWord("1", Tag.NUMERAL.name());
        addWord("2", Tag.NUMERAL.name());
        addWord("3", Tag.NUMERAL.name());
        addWord("4", Tag.NUMERAL.name());
        addWord("5", Tag.NUMERAL.name());
        addWord("6", Tag.NUMERAL.name());
        addWord("7", Tag.NUMERAL.name());
        addWord("8", Tag.NUMERAL.name());
        addWord("9", Tag.NUMERAL.name());

        // Roman
        addWord("I", Tag.NUMERAL.name());
        addWord("II", Tag.NUMERAL.name());
        addWord("III", Tag.NUMERAL.name());
    }
}

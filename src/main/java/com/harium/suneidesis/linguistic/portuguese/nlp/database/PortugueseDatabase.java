package com.harium.suneidesis.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

public class PortugueseDatabase extends WordKnowledgeBase {

    public PortugueseDatabase(KnowledgeBase knowledgeBase) {
        super(knowledgeBase);
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
        addWord("ser", "ser", Tag.VERB.name());
        addWord("é", "ser", Tag.VERB.name());
        addWord("és", "ser", Tag.VERB.name());
        addWord("somos", "ser", Tag.VERB.name());
        addWord("sou", "ser", Tag.VERB.name());
        addWord("são", "ser", Tag.VERB.name());
        addWord("será", "ser", Tag.VERB.name());

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
        addWord(radical + "ar", verb, Tag.VERB.name());
        addWord(radical + "ado", verb, Tag.VERB.name());
        addWord(radical + "ando", verb, Tag.VERB.name());

        // Present
        addWord(radical + "o", verb, Tag.VERB.name());
        addWord(radical + "as", verb, Tag.VERB.name());
        addWord(radical + "a", verb, Tag.VERB.name());
        addWord(radical + "amos", verb, Tag.VERB.name());
        addWord(radical + "ais", verb, Tag.VERB.name());
        addWord(radical + "am", verb, Tag.VERB.name());
        // Past Perfect
        addWord(radical + "ei", verb, Tag.VERB.name());
        addWord(radical + "aste", verb, Tag.VERB.name());
        addWord(radical + "ou", verb, Tag.VERB.name());
        //addWord(radical + "amos", verb, VERB);
        addWord(radical + "astes", verb, Tag.VERB.name());
        addWord(radical + "aram", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "ava", verb, Tag.VERB.name());
        addWord(radical + "avas", verb, Tag.VERB.name());
        //addWord(radical + "ava", verb, VERB);
        addWord(radical + "ávamos", verb, Tag.VERB.name());
        addWord(radical + "áveis", verb, Tag.VERB.name());
        addWord(radical + "avam", verb, Tag.VERB.name());
        // Past more than perfect
        addWord(radical + "ara", verb, Tag.VERB.name());
        addWord(radical + "aras", verb, Tag.VERB.name());
        //addWord(radical + "ara", verb, VERB);
        addWord(radical + "áramos", verb, Tag.VERB.name());
        addWord(radical + "áreis", verb, Tag.VERB.name());
        addWord(radical + "aram", verb, Tag.VERB.name());
        // Present Future
        addWord(radical + "arei", verb, Tag.VERB.name());
        addWord(radical + "arás", verb, Tag.VERB.name());
        addWord(radical + "ará", verb, Tag.VERB.name());
        addWord(radical + "aremos", verb, Tag.VERB.name());
        addWord(radical + "areis", verb, Tag.VERB.name());
        addWord(radical + "arão", verb, Tag.VERB.name());
        // Past Future
        addWord(radical + "aria", verb, Tag.VERB.name());
        addWord(radical + "arias", verb, Tag.VERB.name());
        //addWord(radical + "aria", verb, VERB);
        addWord(radical + "aríamos", verb, Tag.VERB.name());
        addWord(radical + "aríeis", verb, Tag.VERB.name());
        addWord(radical + "ariam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addWord(radical + "e", verb, Tag.VERB.name());
        addWord(radical + "es", verb, Tag.VERB.name());
        addWord(radical + "e", verb, Tag.VERB.name());
        addWord(radical + "emos", verb, Tag.VERB.name());
        addWord(radical + "eis", verb, Tag.VERB.name());
        addWord(radical + "em", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "asse", verb, Tag.VERB.name());
        addWord(radical + "asses", verb, Tag.VERB.name());
        //addWord(radical + "asse", verb, VERB);
        addWord(radical + "ássemos", verb, Tag.VERB.name());
        addWord(radical + "ásseis", verb, Tag.VERB.name());
        addWord(radical + "assem", verb, Tag.VERB.name());
        // Future
        //addWord(radical + "ar", verb, VERB);
        addWord(radical + "ares", verb, Tag.VERB.name());
        //addWord(radical + "ar", verb, VERB);
        addWord(radical + "armos", verb, Tag.VERB.name());
        addWord(radical + "ardes", verb, Tag.VERB.name());
        addWord(radical + "arem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "a", verb, VERB);
        //addWord(radical + "e", verb, VERB);
        //addWord(radical + "emos", verb, VERB);
        addWord(radical + "ai", verb, Tag.VERB.name());
        //addWord(radical + "em", verb, VERB);
        // Negative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "es", verb, VERB);
        //addWord(radical + "e", verb, VERB);
        //addWord(radical + "emos", verb, VERB);
        //addWord(radical + "eis", verb, VERB);
        //addWord(radical + "em", verb, VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-segunda-conjugacao-terminados-em-er/
     *
     * @param verb
     */
    private void addSecondConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        addWord(radical + "er", verb, Tag.VERB.name());
        addWord(radical + "ido", verb, Tag.VERB.name());
        addWord(radical + "endo", verb, Tag.VERB.name());

        // Present
        addWord(radical + "o", verb, Tag.VERB.name());
        addWord(radical + "es", verb, Tag.VERB.name());
        addWord(radical + "e", verb, Tag.VERB.name());
        addWord(radical + "emos", verb, Tag.VERB.name());
        addWord(radical + "eis", verb, Tag.VERB.name());
        addWord(radical + "em", verb, Tag.VERB.name());
        // Past Perfect
        addWord(radical + "i", verb, Tag.VERB.name());
        addWord(radical + "este", verb, Tag.VERB.name());
        addWord(radical + "eu", verb, Tag.VERB.name());
        //addWord(radical + "emos", verb, VERB);
        addWord(radical + "estes", verb, Tag.VERB.name());
        addWord(radical + "eram", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "ia", verb, Tag.VERB.name());
        addWord(radical + "ias", verb, Tag.VERB.name());
        //addWord(radical + "ia", verb, VERB);
        addWord(radical + "íamos", verb, Tag.VERB.name());
        addWord(radical + "íeis", verb, Tag.VERB.name());
        addWord(radical + "iam", verb, Tag.VERB.name());
        // Past more than perfect
        addWord(radical + "era", verb, Tag.VERB.name());
        addWord(radical + "eras", verb, Tag.VERB.name());
        //addWord(radical + "era", verb, VERB);
        addWord(radical + "éramos", verb, Tag.VERB.name());
        addWord(radical + "êreis", verb, Tag.VERB.name());
        addWord(radical + "eram", verb, Tag.VERB.name());
        // Present Future
        addWord(radical + "erei", verb, Tag.VERB.name());
        addWord(radical + "erás", verb, Tag.VERB.name());
        addWord(radical + "erá", verb, Tag.VERB.name());
        addWord(radical + "eremos", verb, Tag.VERB.name());
        addWord(radical + "ereis", verb, Tag.VERB.name());
        addWord(radical + "erão", verb, Tag.VERB.name());
        // Past Future
        addWord(radical + "eria", verb, Tag.VERB.name());
        addWord(radical + "erias", verb, Tag.VERB.name());
        //addWord(radical + "eria", verb, VERB);
        addWord(radical + "eríamos", verb, Tag.VERB.name());
        addWord(radical + "eríeis", verb, Tag.VERB.name());
        addWord(radical + "eriam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addWord(radical + "a", verb, Tag.VERB.name());
        addWord(radical + "as", verb, Tag.VERB.name());
        addWord(radical + "a", verb, Tag.VERB.name());
        addWord(radical + "amos", verb, Tag.VERB.name());
        addWord(radical + "ais", verb, Tag.VERB.name());
        addWord(radical + "am", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "esse", verb, Tag.VERB.name());
        addWord(radical + "esses", verb, Tag.VERB.name());
        //addWord(radical + "esse", verb, VERB);
        addWord(radical + "êssemos", verb, Tag.VERB.name());
        addWord(radical + "êsseis", verb, Tag.VERB.name());
        addWord(radical + "essem", verb, Tag.VERB.name());
        // Future
        //addWord(radical + "er", verb, VERB);
        addWord(radical + "eres", verb, Tag.VERB.name());
        //addWord(radical + "er", verb, VERB);
        addWord(radical + "ermos", verb, Tag.VERB.name());
        addWord(radical + "erdes", verb, Tag.VERB.name());
        addWord(radical + "erem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "e", verb, VERB);
        //addWord(radical + "a", verb, VERB);
        //addWord(radical + "amos", verb, VERB);
        addWord(radical + "ei", verb, Tag.VERB.name());
        //addWord(radical + "am", verb, VERB);
        // Negative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "as", verb, VERB);
        //addWord(radical + "a", verb, VERB);
        //addWord(radical + "amos", verb, VERB);
        //addWord(radical + "ais", verb, VERB);
        //addWord(radical + "am", verb, VERB);
    }

    /**
     * https://www.conjugacao.com.br/verbos-da-terceira-conjugacao-terminados-em-ir/
     *
     * @param verb
     */
    private void addThirdConjugation(String verb) {
        String radical = verb.substring(0, verb.length() - 2);
        // Nominal forms
        addWord(radical + "ir", verb, Tag.VERB.name());
        addWord(radical + "ido", verb, Tag.VERB.name());
        addWord(radical + "indo", verb, Tag.VERB.name());

        // Present
        addWord(radical + "o", verb, Tag.VERB.name());
        addWord(radical + "es", verb, Tag.VERB.name());
        addWord(radical + "e", verb, Tag.VERB.name());
        addWord(radical + "imos", verb, Tag.VERB.name());
        addWord(radical + "is", verb, Tag.VERB.name());
        addWord(radical + "em", verb, Tag.VERB.name());
        // Past Perfect
        addWord(radical + "i", verb, Tag.VERB.name());
        addWord(radical + "iste", verb, Tag.VERB.name());
        addWord(radical + "iu", verb, Tag.VERB.name());
        //addWord(radical + "imos", verb, VERB);
        addWord(radical + "istes", verb, Tag.VERB.name());
        addWord(radical + "iram", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "ia", verb, Tag.VERB.name());
        addWord(radical + "ias", verb, Tag.VERB.name());
        //addWord(radical + "ia", verb, VERB);
        addWord(radical + "íamos", verb, Tag.VERB.name());
        addWord(radical + "íeis", verb, Tag.VERB.name());
        addWord(radical + "iam", verb, Tag.VERB.name());
        // Past more than perfect
        addWord(radical + "ira", verb, Tag.VERB.name());
        addWord(radical + "iras", verb, Tag.VERB.name());
        //addWord(radical + "ira", verb, VERB);
        addWord(radical + "íramos", verb, Tag.VERB.name());
        addWord(radical + "íreis", verb, Tag.VERB.name());
        addWord(radical + "iram", verb, Tag.VERB.name());
        // Present Future
        addWord(radical + "irei", verb, Tag.VERB.name());
        addWord(radical + "irás", verb, Tag.VERB.name());
        addWord(radical + "irá", verb, Tag.VERB.name());
        addWord(radical + "iremos", verb, Tag.VERB.name());
        addWord(radical + "ireis", verb, Tag.VERB.name());
        addWord(radical + "irão", verb, Tag.VERB.name());
        // Past Future
        addWord(radical + "iria", verb, Tag.VERB.name());
        addWord(radical + "irias", verb, Tag.VERB.name());
        //addWord(radical + "iria", verb, VERB);
        addWord(radical + "iríamos", verb, Tag.VERB.name());
        addWord(radical + "iríeis", verb, Tag.VERB.name());
        addWord(radical + "iriam", verb, Tag.VERB.name());
        // Subjunctive Mood
        // Present
        addWord(radical + "a", verb, Tag.VERB.name());
        addWord(radical + "as", verb, Tag.VERB.name());
        addWord(radical + "a", verb, Tag.VERB.name());
        addWord(radical + "amos", verb, Tag.VERB.name());
        addWord(radical + "ais", verb, Tag.VERB.name());
        addWord(radical + "am", verb, Tag.VERB.name());
        // Past Imperfect
        addWord(radical + "isse", verb, Tag.VERB.name());
        addWord(radical + "isses", verb, Tag.VERB.name());
        //addWord(radical + "isse", verb, VERB);
        addWord(radical + "íssemos", verb, Tag.VERB.name());
        addWord(radical + "ísseis", verb, Tag.VERB.name());
        addWord(radical + "issem", verb, Tag.VERB.name());
        // Future
        //addWord(radical + "ir", verb, VERB);
        addWord(radical + "ires", verb, Tag.VERB.name());
        //addWord(radical + "ir", verb, VERB);
        addWord(radical + "irmos", verb, Tag.VERB.name());
        addWord(radical + "irdes", verb, Tag.VERB.name());
        addWord(radical + "irem", verb, Tag.VERB.name());
        // Imperative
        // Affirmative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "e", verb, VERB);
        //addWord(radical + "a", verb, VERB);
        //addWord(radical + "amos", verb, VERB);
        addWord(radical + "i", verb, Tag.VERB.name());
        //addWord(radical + "am", verb, VERB);
        // Negative
        //addWord(radical + "--", verb, VERB);
        //addWord(radical + "as", verb, VERB);
        //addWord(radical + "a", verb, VERB);
        //addWord(radical + "amos", verb, VERB);
        //addWord(radical + "ais", verb, VERB);
        //addWord(radical + "am", verb, VERB);
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

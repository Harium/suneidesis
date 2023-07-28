package com.harium.suneidesis.linguistic.nlp.pos.wrapper;

import com.harium.aal.core.Processor;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.Token;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.converter.SpaCyUniversalTagConverter;
import com.harium.suneidesis.linguistic.nlp.pos.converter.StringToTagConverter;

public class SpaCyNLP implements NLP {

    public static final String PORTUGUESE_MODULE = "pt_core_news_md";

    public static final String VAR_MODEL = "$model";
    public static final String VAR_SENTENCE = "$sentence";

    private final String PYTHON_NLP =
                          "import spacy\n" +
                          "nlp = spacy.load('" + VAR_MODEL + "')\n" +
                          "document = nlp('" + VAR_SENTENCE + "')\n" +
                          "for token in document:\n" +
                          "  print(token, token.lemma_, token.tag_)\n";

    private final String languageModel;

    private final StringToTagConverter converter;

    public SpaCyNLP(String languageModel) {
        this(languageModel, new SpaCyUniversalTagConverter());
    }

    public SpaCyNLP(String languageModel, StringToTagConverter converter) {
        this.languageModel = languageModel;
        this.converter = converter;
    }

    @Override
    public Token[] nlp(String sentence) {
        // TODO sanitize sequence to prevent code execution
        String code = PYTHON_NLP.replace(VAR_MODEL, languageModel).replace(VAR_SENTENCE, sentence);

        String[] cmd = {"python", "-c", code};
        String output = Processor.runOutput(cmd);

        String[] lines = output.split("\n");
        Token[] result = new Token[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] tags = line.split(" ");

            String word = tags[0];
            String lemma = tags[1];
            Tag tag = converter.convert(tags[2]);

            result[i] = new Token(word, lemma, tag);
        }

        return result;
    }

}

package com.harium.suneidesis.linguistic.nlp.pos.wrapper;

import com.harium.aal.core.Processor;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.Token;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.converter.SpaCyUniversalTagConverter;
import com.harium.suneidesis.linguistic.nlp.pos.converter.StringToTagConverter;
import org.jetbrains.annotations.NotNull;

public class SpaCyNLP implements NLP {

    public static final String PORTUGUESE_MODULE = "pt_core_news_md";

    public static final String VAR_MODEL = "$model";
    public static final String VAR_SENTENCE = "$sentence";

    private static final String PYTHON_NLP =
                          "import spacy\n" +
                          "nlp = spacy.load('" + VAR_MODEL + "')\n" +
                          "document = nlp('" + VAR_SENTENCE + "')\n" +
                          "for token in document:\n" +
                          "  print(token, token.tag_, token.lemma_)\n";

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
        String code = buildCode(languageModel, sentence);

        String[] cmd = {"python", "-c", code};
        String output = Processor.runOutput(cmd);

        String[] lines = output.split("\n");
        Token[] result = new Token[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] tags = line.split(" ");

            String word = tags[0];
            Tag tag = converter.convert(tags[1]);

            StringBuilder sb = new StringBuilder();
            for (int s = 2; s < tags.length; s++) {
                sb.append(tags[s]);
                if (s < tags.length - 1) {
                    sb.append(" ");
                }
            }
            String lemma = sb.toString();

            result[i] = new Token(word, lemma, tag);
        }

        return result;
    }

    public static String buildCode(String languageModel, String sentence) {
        // TODO sanitize sequence to prevent code execution
        return PYTHON_NLP.replace(VAR_MODEL, languageModel).replace(VAR_SENTENCE, sentence);
    }

}

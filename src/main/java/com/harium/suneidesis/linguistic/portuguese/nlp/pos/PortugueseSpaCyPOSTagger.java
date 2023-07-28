package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.wrapper.SpaCyNLP;
import com.harium.suneidesis.linguistic.nlp.pos.wrapper.SpaCyPOSTagger;

public class PortugueseSpaCyPOSTagger extends SpaCyPOSTagger {

    public PortugueseSpaCyPOSTagger() {
        super(SpaCyNLP.PORTUGUESE_MODULE);
    }

}

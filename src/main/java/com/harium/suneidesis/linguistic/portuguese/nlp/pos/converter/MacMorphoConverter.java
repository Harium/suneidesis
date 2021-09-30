package com.harium.suneidesis.linguistic.portuguese.nlp.pos.converter;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.converter.TagConverter;

/**
 * Tags from: http://nilc.icmc.usp.br/macmorpho/macmorpho-manual.pdf
 */
public class MacMorphoConverter implements TagConverter {

    private static final String ARTIGO = "ART";
    private static final String ADJETIVO = "ADJ";
    private static final String ADVERBIO = "ADV";
    private static final String NOME = "N";
    private static final String NOME_PROPRIO = "NPROP";
    private static final String NUMERAL = "NUM";
    private static final String PRONOME_ADJETIVO = "PROADJ";
    private static final String PRONOME_SUBSTANTIVO = "PROSUB";
    private static final String PRONOME_PESSOAL = "PROPESS";
    private static final String PRONOME_CONECTIVO_SUBORDINATIVO = "PRO-KS";
    private static final String PRONOME_CONECTIVO_SUBORDINATIVO_RELATIVO = "PRO-KS-REL";

    @Override
    public String convert(Tag tag) {
        switch (tag) {
        case DETERMINER:
            return ARTIGO;
        case ADJECTIVE:
            return ADJETIVO;
        case NOUN:
            return NOME;
        case NOUN_PROPER:
            return NOME_PROPRIO;
        case NUMERAL:
            return NUMERAL;
        case PRONOUN:
            return PRONOME_SUBSTANTIVO;
        case POSSESSIVE_PRONOUN:
            return PRONOME_ADJETIVO;
        case PERSONAL_PRONOUN:
            return PRONOME_PESSOAL;
        case WH_PRONOUN:
            return PRONOME_CONECTIVO_SUBORDINATIVO;
        case WH_POSSESSIVE_PRONOUN:
            return PRONOME_CONECTIVO_SUBORDINATIVO_RELATIVO;
        case ADVERB:
            return ADVERBIO;
        default:
            return Tag.UNKNOWN.name();
        }
    }
}

package com.harium.suneidesis.concept;

/**
 * Theory types from:
 * A. G. Larkins & C. W. McKinney (1980)
 * Four Types of Theory: Implications for Research in Social Education, Theory & Research in Social Education,
 * 8:1, 9-17, DOI: 10.1080/00933104.1980.10506072
 */
public class Theory extends Concept {

    protected static final String ATTRIBUTE_TYPE = "theory_type";

    public static final Concept TYPE_CLASSIC = new Concept("classic");
    public static final Concept TYPE_CRITICISM = new Concept("criticism");
    public static final Concept TYPE_TAXONOMIC = new Concept("taxonomic");
    public static final Concept TYPE_SCIENTIFIC = new Concept("scientific");

    public Theory(String name) {
        super(name, ConceptType.THEORY);
    }

    public Theory setTheoryType(Concept type) {
        has(ATTRIBUTE_TYPE, type);
        return this;
    }

    public Concept getTheoryType() {
        return get(ATTRIBUTE_TYPE);
    }

}

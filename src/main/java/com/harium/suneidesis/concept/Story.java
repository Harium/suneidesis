package com.harium.suneidesis.concept;

/**
 * Story is a special type o theory that represents a succession of events
 */
public class Story extends Concept {

    public static final String ATTRIBUTE_BEGINNING = "story_beginning";
    public static final String ATTRIBUTE_TITLE = "title";
    public static final String ATTRIBUTE_AUTHOR = "author";
    protected static final String ATTRIBUTE_TYPE = "story_type";

    public static final Concept TYPE_FICTIONAL = new Concept("fictional");
    public static final Concept TYPE_REAL = new Concept("real");

    public Story(String name) {
        super(name, ConceptType.STORY);
    }

    public Story author(Concept author) {
        has(ATTRIBUTE_AUTHOR, author);
        return this;
    }

    public Story author(String author) {
        has(ATTRIBUTE_AUTHOR, new Concept(author));
        return this;
    }

    public Concept getAuthor() {
        return get(ATTRIBUTE_AUTHOR);
    }

    public Story title(Concept title) {
        has(ATTRIBUTE_TITLE, title);
        return this;
    }

    public Story title(String title) {
        has(ATTRIBUTE_TITLE, new Concept(title));
        return this;
    }

    public Concept getTitle() {
        return get(ATTRIBUTE_TITLE);
    }

    public Story begin(Event event) {
        has(ATTRIBUTE_BEGINNING, event);
        return this;
    }

    public Event getBegin() {
        return (Event) get(ATTRIBUTE_BEGINNING);
    }

    public Story storyType(Concept type) {
        has(ATTRIBUTE_TYPE, type);
        return this;
    }

    public Concept getStoryType() {
        return get(ATTRIBUTE_TYPE);
    }

    @Override
    public Story wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }

}

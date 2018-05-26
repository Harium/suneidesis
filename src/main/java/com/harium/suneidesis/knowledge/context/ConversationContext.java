package com.harium.suneidesis.knowledge.context;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.space.SpaceConcept;
import com.harium.suneidesis.knowledge.time.TemporalConcept;

import java.util.List;

public class ConversationContext extends Context {

    private Concept subject;
    private List<Concept> participants;

    public ConversationContext(TemporalConcept when) {
        super(when);
    }

    public ConversationContext(TemporalConcept when, SpaceConcept where) {
        super(when, where);
    }

    public ConversationContext(List<Concept> participants) {
        this.participants = participants;
    }

    public Concept getSubject() {
        return subject;
    }

    public void setSubject(Concept subject) {
        this.subject = subject;
    }

    public List<Concept> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Concept> participants) {
        this.participants = participants;
    }
}

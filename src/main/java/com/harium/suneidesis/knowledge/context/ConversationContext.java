package com.harium.suneidesis.knowledge.context;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.space.SpaceConcept;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;
import com.harium.suneidesis.knowledge.time.TemporalConcept;

import java.util.Collection;

public class ConversationContext extends Context {

    private Concept subject = Concept.UNKNOWN;
    private Repository<Concept> participants = new MemoryRepository<>();

    public ConversationContext(TemporalConcept when) {
        super(when);
    }

    public ConversationContext(TemporalConcept when, SpaceConcept where) {
        super(when, where);
    }

    public ConversationContext(Repository<Concept> participants) {
        this.participants = participants;
    }

    public Concept getSubject() {
        return subject;
    }

    public void setSubject(Concept subject) {
        this.subject = subject;
    }

    public Collection<Concept> getParticipantsAsList() {
        return participants.getAll();
    }

    public Repository<Concept> getParticipants() {
        return participants;
    }

    public void setParticipants(Repository<Concept> participants) {
        this.participants = participants;
    }
}

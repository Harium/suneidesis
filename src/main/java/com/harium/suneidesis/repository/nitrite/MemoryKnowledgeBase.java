package com.harium.suneidesis.repository.nitrite;

import com.harium.suneidesis.repository.PersistentKnowledgeBase;

public class MemoryKnowledgeBase extends PersistentKnowledgeBase {

    public MemoryKnowledgeBase() {
        super();
    }

    public MemoryKnowledgeBase(String name) {
        super();
        setName(name);
    }

}

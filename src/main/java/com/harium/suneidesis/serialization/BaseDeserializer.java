package com.harium.suneidesis.serialization;

import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.merge.CreateNewMergeStrategy;
import com.harium.suneidesis.repository.merge.MergeStrategy;
import com.harium.suneidesis.repository.merge.MergeStrategyType;
import com.harium.suneidesis.repository.merge.OverwriteMergeStrategy;

public class BaseDeserializer {

    private MergeStrategyType mergeStrategyType = MergeStrategyType.OVERWRITE;

    public BaseDeserializer(MergeStrategyType mergeStrategyType) {
        this.mergeStrategyType = mergeStrategyType;
    }

    protected MergeStrategy buildMergeStrategy(KnowledgeBase base) {
        MergeStrategy strategy = null;

        switch (mergeStrategyType) {
        case CREATE_NEW:
            strategy = new CreateNewMergeStrategy(base);
            break;
        case OVERWRITE:
            strategy = new OverwriteMergeStrategy(base);
            break;
        case ACCUMULATE:
            throw new RuntimeException("Not implemented");
        }

        return strategy;
    }
}

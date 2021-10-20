package com.harium.suneidesis.repository.merge;

import com.harium.suneidesis.repository.KnowledgeBase;

public class MergeStrategyFactory {

    public static MergeStrategy buildMergeStrategy(MergeStrategyType mergeStrategyType, KnowledgeBase base) {
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

package com.harium.suneidesis.serialization;

import com.harium.suneidesis.repository.merge.MergeStrategyType;

public class BaseDeserializer {

    protected MergeStrategyType mergeStrategyType = MergeStrategyType.OVERWRITE;

    public BaseDeserializer(MergeStrategyType mergeStrategyType) {
        this.mergeStrategyType = mergeStrategyType;
    }

}

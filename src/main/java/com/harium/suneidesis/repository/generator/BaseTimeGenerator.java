package com.harium.suneidesis.repository.generator;

public class BaseTimeGenerator implements TimeGenerator {

    @Override
    public String generateTime() {
        return Long.toString(System.currentTimeMillis());
    }
}

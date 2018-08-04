package com.harium.suneidesis.knowledge.weather;

import com.harium.suneidesis.knowledge.concept.Concept;

public class Weather extends Concept {

    private WeatherType type;

    public Weather(WeatherType type) {
        this.type = type;
    }

    public WeatherType getWeather() {
        return type;
    }

    public void setWeather(WeatherType type) {
        this.type = type;
    }
}

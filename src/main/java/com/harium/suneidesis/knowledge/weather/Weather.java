package com.harium.suneidesis.knowledge.weather;

import com.harium.suneidesis.concept.Phenomenon;

public class Weather {

    private static final Phenomenon SUNNY = weather("sunny");
    private static final Phenomenon CLOUDY = weather("cloudy");
    private static final Phenomenon RAINY = weather("rainy");
    private static final Phenomenon SNOWY = weather("snowy");
    private static final Phenomenon WINDY = weather("windy");

    private static Phenomenon weather(String name) {
        Phenomenon phenomenon = new Phenomenon(name);
        phenomenon.setPhenomenonType(Phenomenon.TYPE_WEATHER);
        return phenomenon;
    }

}

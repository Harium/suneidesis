package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent instance's responses based on input
 */

public abstract class LanguageBox {

    protected List<Parser> parsers = new ArrayList<>();

    public abstract String input(String sentence, Instance instance);

}

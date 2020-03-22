package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.Instance;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent instance's responses based on input
 */

public abstract class LanguageBox {

    protected List<Parser> parsers = new ArrayList<>();

    public abstract void input(String sentence, Instance instance, Output output);

}

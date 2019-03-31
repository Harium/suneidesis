package com.harium.suneidesis.knowledge.linguistic.portuguese.math;

import com.harium.suneidesis.knowledge.linguistic.core.math.NumberToWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberToWordTest {

    private NumberToWord converter;

    @Before
    public void setUp() {
        converter = new SimpleNumberToWord();
    }

    @Test
    public void testLessThanTen() {
        Assert.assertEquals("zero", converter.toWord(0));
        Assert.assertEquals("um", converter.toWord(1));
        Assert.assertEquals("dois", converter.toWord(2));
        Assert.assertEquals("três", converter.toWord(3));
        Assert.assertEquals("quatro", converter.toWord(4));
        Assert.assertEquals("cinco", converter.toWord(5));
        Assert.assertEquals("seis", converter.toWord(6));
        Assert.assertEquals("sete", converter.toWord(7));
        Assert.assertEquals("oito", converter.toWord(8));
        Assert.assertEquals("nove", converter.toWord(9));
    }

    @Test
    public void testTens() {
        Assert.assertEquals("dez", converter.toWord(10));
        Assert.assertEquals("onze", converter.toWord(11));
        Assert.assertEquals("doze", converter.toWord(12));
        Assert.assertEquals("treze", converter.toWord(13));
        Assert.assertEquals("quatorze", converter.toWord(14));
        Assert.assertEquals("quinze", converter.toWord(15));
        Assert.assertEquals("dezesseis", converter.toWord(16));
        Assert.assertEquals("dezessete", converter.toWord(17));
        Assert.assertEquals("dezoito", converter.toWord(18));
        Assert.assertEquals("dezenove", converter.toWord(19));
    }

    @Test
    public void testGreaterThanTwenty() {
        Assert.assertEquals("vinte e um", converter.toWord(21));
        Assert.assertEquals("trinta e dois", converter.toWord(32));
        Assert.assertEquals("quarenta e três", converter.toWord(43));
        Assert.assertEquals("cinquenta e quatro", converter.toWord(54));
        Assert.assertEquals("sessenta e cinco", converter.toWord(65));
        Assert.assertEquals("setenta e seis", converter.toWord(76));
        Assert.assertEquals("oitenta e sete", converter.toWord(87));
        Assert.assertEquals("noventa e oito", converter.toWord(98));
        Assert.assertEquals("cem", converter.toWord(100));
        Assert.assertEquals("mil", converter.toWord(1000));
    }

    @Test
    public void testGreaterThanOneHundred() {
        Assert.assertEquals("cento e nove", converter.toWord(109));
        Assert.assertEquals("duzentos e oito", converter.toWord(208));
        Assert.assertEquals("trezentos e sete", converter.toWord(307));
        Assert.assertEquals("quatrocentos e oitenta e seis", converter.toWord(486));
    }

}

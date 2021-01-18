package com.harium.suneidesis.linguistic.portuguese.math;

import com.harium.suneidesis.linguistic.math.WordToNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class WordToNumberTest {

    private WordToNumber converter;

    @Before
    public void setUp() {
        converter = new SimpleWordToNumber();
    }

    @Test
    public void testLessThanTen() {
        Assert.assertEquals(new BigDecimal(0), converter.toNumber("zero"));
        Assert.assertEquals(new BigDecimal(1), converter.toNumber("um"));
        Assert.assertEquals(new BigDecimal(2), converter.toNumber("dois"));
        Assert.assertEquals(new BigDecimal(3), converter.toNumber("três"));
        Assert.assertEquals(new BigDecimal(4), converter.toNumber("quatro"));
        Assert.assertEquals(new BigDecimal(5), converter.toNumber("cinco"));
        Assert.assertEquals(new BigDecimal(6), converter.toNumber("seis"));
        Assert.assertEquals(new BigDecimal(7), converter.toNumber("sete"));
        Assert.assertEquals(new BigDecimal(8), converter.toNumber("oito"));
        Assert.assertEquals(new BigDecimal(9), converter.toNumber("nove"));
    }

    @Test
    public void testTens() {
        Assert.assertEquals(new BigDecimal(10), converter.toNumber("dez"));
        Assert.assertEquals(new BigDecimal(11), converter.toNumber("onze"));
        Assert.assertEquals(new BigDecimal(12), converter.toNumber("doze"));
        Assert.assertEquals(new BigDecimal(13), converter.toNumber("treze"));
        Assert.assertEquals(new BigDecimal(14), converter.toNumber("catorze"));
        Assert.assertEquals(new BigDecimal(14), converter.toNumber("quatorze"));
        Assert.assertEquals(new BigDecimal(15), converter.toNumber("quinze"));
        Assert.assertEquals(new BigDecimal(16), converter.toNumber("dezesseis"));
        Assert.assertEquals(new BigDecimal(17), converter.toNumber("dezessete"));
        Assert.assertEquals(new BigDecimal(18), converter.toNumber("dezoito"));
        Assert.assertEquals(new BigDecimal(19), converter.toNumber("dezenove"));
        Assert.assertEquals(new BigDecimal(20), converter.toNumber("vinte"));
        Assert.assertEquals(new BigDecimal(30), converter.toNumber("trinta"));
        Assert.assertEquals(new BigDecimal(40), converter.toNumber("quarenta"));
        Assert.assertEquals(new BigDecimal(50), converter.toNumber("cinquenta"));
        Assert.assertEquals(new BigDecimal(60), converter.toNumber("sessenta"));
        Assert.assertEquals(new BigDecimal(70), converter.toNumber("setenta"));
        Assert.assertEquals(new BigDecimal(80), converter.toNumber("oitenta"));
        Assert.assertEquals(new BigDecimal(90), converter.toNumber("noventa"));
        Assert.assertEquals(new BigDecimal(100), converter.toNumber("cem"));
        Assert.assertEquals(new BigDecimal(1000), converter.toNumber("mil"));
    }

    @Test
    public void testGreaterThanTwenty() {
        Assert.assertEquals(new BigDecimal(21), converter.toNumber("vinte e um"));
        Assert.assertEquals(new BigDecimal(32), converter.toNumber("trinta e dois"));
        Assert.assertEquals(new BigDecimal(43), converter.toNumber("quarenta e três"));
        Assert.assertEquals(new BigDecimal(54), converter.toNumber("cinquenta e quatro"));
        Assert.assertEquals(new BigDecimal(65), converter.toNumber("sessenta e cinco"));
        Assert.assertEquals(new BigDecimal(76), converter.toNumber("setenta e seis"));
        Assert.assertEquals(new BigDecimal(87), converter.toNumber("oitenta e sete"));
        Assert.assertEquals(new BigDecimal(98), converter.toNumber("noventa e oito"));
    }

    @Test
    public void testGreaterThanOneHundred() {
        Assert.assertEquals(new BigDecimal(109), converter.toNumber("cento e nove"));
        Assert.assertEquals(new BigDecimal(208), converter.toNumber("duzentos e oito"));
        Assert.assertEquals(new BigDecimal(307), converter.toNumber("trezentos e sete"));
        Assert.assertEquals(new BigDecimal(486), converter.toNumber("quatrocentos e oitenta e seis"));
        Assert.assertEquals(new BigDecimal(620), converter.toNumber("seiscentos e vinte"));
        Assert.assertEquals(new BigDecimal(191), converter.toNumber("cento e noventa e um"));
        Assert.assertEquals(new BigDecimal(1002), converter.toNumber("um mil e dois"));
        Assert.assertEquals(new BigDecimal(1002), converter.toNumber("mil e dois"));
        Assert.assertEquals(new BigDecimal(3154), converter.toNumber("três mil cento e cinquenta e quatro"));
        Assert.assertEquals(new BigDecimal(154154), converter.toNumber("cento e cinquenta e quatro mil cento e cinquenta e quatro"));
        Assert.assertEquals(new BigDecimal(999999), converter.toNumber("novecentos e noventa e nove mil novecentos e noventa e nove"));
    }

    @Test
    public void testGreaterThanOneMillion() {
        Assert.assertEquals(new BigDecimal(1000001), converter.toNumber("um milhão e um"));
        Assert.assertEquals(new BigDecimal(109000000), converter.toNumber("cento e nove milhões"));
        Assert.assertEquals(new BigDecimal(999999999), converter.toNumber("novecentos e noventa e nove milhões novecentos e noventa e nove mil novecentos e noventa e nove"));
        Assert.assertEquals(new BigDecimal(2999999999L), converter.toNumber("dois bilhões novecentos e noventa e nove milhões novecentos e noventa e nove mil novecentos e noventa e nove"));
    }

}

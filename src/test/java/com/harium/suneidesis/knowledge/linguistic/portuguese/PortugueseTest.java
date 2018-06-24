package com.harium.suneidesis.knowledge.linguistic.portuguese;

import org.junit.Assert;
import org.junit.Test;

public class PortugueseTest {

    @Test
    public void testIsVowel() {
        Assert.assertTrue(Portuguese.isVowel('á'));
        Assert.assertTrue(Portuguese.isVowel('à'));
        Assert.assertTrue(Portuguese.isVowel('ã'));
        Assert.assertTrue(Portuguese.isVowel('a'));
        Assert.assertTrue(Portuguese.isVowel('é'));
        Assert.assertTrue(Portuguese.isVowel('ê'));
        Assert.assertTrue(Portuguese.isVowel('e'));
        Assert.assertTrue(Portuguese.isVowel('í'));
        Assert.assertTrue(Portuguese.isVowel('ó'));
        Assert.assertTrue(Portuguese.isVowel('ô'));
        Assert.assertTrue(Portuguese.isVowel('õ'));
        Assert.assertTrue(Portuguese.isVowel('o'));
        Assert.assertTrue(Portuguese.isVowel('ú'));
        Assert.assertTrue(Portuguese.isVowel('ü'));
        Assert.assertTrue(Portuguese.isVowel('u'));

        Assert.assertFalse(Portuguese.isVowel('b'));
        Assert.assertFalse(Portuguese.isVowel('c'));
        Assert.assertFalse(Portuguese.isVowel('d'));
    }

    @Test
    public void testIsConsonant() {
        Assert.assertTrue(Portuguese.isConsonant('b'));
        Assert.assertTrue(Portuguese.isConsonant('c'));
        Assert.assertTrue(Portuguese.isConsonant('d'));

        Assert.assertFalse(Portuguese.isConsonant('a'));
    }

    @Test
    public void testVowelCount() {
        Assert.assertEquals(0, Portuguese.vowelCount(0, "b"));
        Assert.assertEquals(1, Portuguese.vowelCount(0, "a"));
        Assert.assertEquals(2, Portuguese.vowelCount(0, "ae"));
        Assert.assertEquals(2, Portuguese.vowelCount(1, "boi"));
        Assert.assertEquals(2, Portuguese.vowelCount(1, "dois"));
    }

    @Test
    public void testRawVowel() {
        Assert.assertEquals('a', Portuguese.rawVowel('á'));
        Assert.assertEquals('a', Portuguese.rawVowel('à'));
        Assert.assertEquals('a', Portuguese.rawVowel('a'));
        Assert.assertEquals('e', Portuguese.rawVowel('é'));
        Assert.assertEquals('e', Portuguese.rawVowel('ê'));
        Assert.assertEquals('e', Portuguese.rawVowel('e'));
        Assert.assertEquals('i', Portuguese.rawVowel('í'));
        Assert.assertEquals('o', Portuguese.rawVowel('ó'));
        Assert.assertEquals('o', Portuguese.rawVowel('ô'));
        Assert.assertEquals('u', Portuguese.rawVowel('ú'));
        Assert.assertEquals('u', Portuguese.rawVowel('ü'));
        Assert.assertEquals('u', Portuguese.rawVowel('u'));
    }

    @Test
    public void testIsTriphthong() {
        Assert.assertTrue(Portuguese.isTriphthong("uau"));
        Assert.assertTrue(Portuguese.isTriphthong("uai"));
        Assert.assertFalse(Portuguese.isTriphthong("oi"));
        Assert.assertFalse(Portuguese.isTriphthong("tchau"));
    }

    @Test
    public void testIsCrescentDiphthong() {
        Assert.assertTrue(Portuguese.isCrescentDiphthong("ia"));
        Assert.assertTrue(Portuguese.isCrescentDiphthong("ua"));
    }

    @Test
    public void testIsDecrescentDiphthong() {
        Assert.assertTrue(Portuguese.isDecrescentDiphthong("ai"));
        Assert.assertTrue(Portuguese.isDecrescentDiphthong("au"));
    }

    @Test
    public void testVowelWithTilde() {
        Assert.assertEquals('ã', Portuguese.vowelWithTilde('a'));
        Assert.assertEquals('ẽ', Portuguese.vowelWithTilde('e'));
        Assert.assertEquals('ĩ', Portuguese.vowelWithTilde('i'));
        Assert.assertEquals('õ', Portuguese.vowelWithTilde('o'));
        Assert.assertEquals('ũ', Portuguese.vowelWithTilde('u'));
    }
}

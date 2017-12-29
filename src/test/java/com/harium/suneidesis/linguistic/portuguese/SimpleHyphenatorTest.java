package com.harium.suneidesis.linguistic.portuguese;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleHyphenatorTest {

    private SimpleHyphenator hyphenizer;

    @Before
    public void setUp() {
        hyphenizer = new SimpleHyphenator();
    }

    @Test
    public void testIsVowel() {
        Assert.assertTrue(SimpleHyphenator.isVowel('á'));
        Assert.assertTrue(SimpleHyphenator.isVowel('à'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ã'));
        Assert.assertTrue(SimpleHyphenator.isVowel('a'));
        Assert.assertTrue(SimpleHyphenator.isVowel('é'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ê'));
        Assert.assertTrue(SimpleHyphenator.isVowel('e'));
        Assert.assertTrue(SimpleHyphenator.isVowel('í'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ó'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ô'));
        Assert.assertTrue(SimpleHyphenator.isVowel('õ'));
        Assert.assertTrue(SimpleHyphenator.isVowel('o'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ú'));
        Assert.assertTrue(SimpleHyphenator.isVowel('ü'));
        Assert.assertTrue(SimpleHyphenator.isVowel('u'));

        Assert.assertFalse(SimpleHyphenator.isVowel('b'));
        Assert.assertFalse(SimpleHyphenator.isVowel('c'));
        Assert.assertFalse(SimpleHyphenator.isVowel('d'));
    }

    @Test
    public void testIsConsonant() {
        Assert.assertTrue(SimpleHyphenator.isConsonant('b'));
        Assert.assertTrue(SimpleHyphenator.isConsonant('c'));
        Assert.assertTrue(SimpleHyphenator.isConsonant('d'));

        Assert.assertFalse(SimpleHyphenator.isConsonant('a'));
    }

    @Test
    public void testVowelCount() {
        Assert.assertEquals(0, SimpleHyphenator.vowelCount(0, "b"));
        Assert.assertEquals(1, SimpleHyphenator.vowelCount(0, "a"));
        Assert.assertEquals(2, SimpleHyphenator.vowelCount(0, "ae"));
        Assert.assertEquals(2, SimpleHyphenator.vowelCount(1, "boi"));
        Assert.assertEquals(2, SimpleHyphenator.vowelCount(1, "dois"));
    }

    @Test
    public void testRawVowel() {
        Assert.assertEquals('a', SimpleHyphenator.rawVowel('á'));
        Assert.assertEquals('a', SimpleHyphenator.rawVowel('à'));
        Assert.assertEquals('a', SimpleHyphenator.rawVowel('a'));
        Assert.assertEquals('e', SimpleHyphenator.rawVowel('é'));
        Assert.assertEquals('e', SimpleHyphenator.rawVowel('ê'));
        Assert.assertEquals('e', SimpleHyphenator.rawVowel('e'));
        Assert.assertEquals('i', SimpleHyphenator.rawVowel('í'));
        Assert.assertEquals('o', SimpleHyphenator.rawVowel('ó'));
        Assert.assertEquals('o', SimpleHyphenator.rawVowel('ô'));
        Assert.assertEquals('u', SimpleHyphenator.rawVowel('ú'));
        Assert.assertEquals('u', SimpleHyphenator.rawVowel('ü'));
        Assert.assertEquals('u', SimpleHyphenator.rawVowel('u'));
    }

    @Test
    public void testIsTriphthong() {
        Assert.assertTrue(SimpleHyphenator.isTriphthong("uau"));
        Assert.assertTrue(SimpleHyphenator.isTriphthong("uai"));
        Assert.assertFalse(SimpleHyphenator.isTriphthong("oi"));
        Assert.assertFalse(SimpleHyphenator.isTriphthong("tchau"));
    }

    @Test
    public void testIsCrescentDiphthong() {
        Assert.assertTrue(SimpleHyphenator.isCrescentDiphthong("ia"));
        Assert.assertTrue(SimpleHyphenator.isCrescentDiphthong("ua"));
    }

    @Test
    public void testIsDecrescentDiphthong() {
        Assert.assertTrue(SimpleHyphenator.isDecrescentDiphthong("ai"));
        Assert.assertTrue(SimpleHyphenator.isDecrescentDiphthong("au"));
    }

    @Test
    public void testHyphenizePolysyllabic() {
        Assert.assertTrue(check(hyphenizer.hyphenate("inconstitucional"), "in", "cons", "ti", "tu", "ci", "o", "nal"));
        Assert.assertTrue(check(hyphenizer.hyphenate("pneumático"), "pneu", "má", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("mnemônico"), "mne", "mô", "ni", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("diagnóstico"), "di", "ag", "nós", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("electrodiagnóstico"), "e", "lec", "tro", "di", "ag", "nós", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("zoologia"), "zo", "o", "lo", "gi", "a"));
        Assert.assertTrue(check(hyphenizer.hyphenate("caatinga"), "ca", "a", "tin", "ga"));
        Assert.assertTrue(check(hyphenizer.hyphenate("transatlântico"), "tran", "sa", "tlân", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("occipital"), "oc", "ci", "pi", "tal"));
        Assert.assertTrue(check(hyphenizer.hyphenate("samambaial"), "sa", "mam", "bai", "al"));
        Assert.assertTrue(check(hyphenizer.hyphenate("perspectiva"), "pers", "pec", "ti", "va"));
    }

    @Test
    public void testHyphenizeTrisyllabic() {
        Assert.assertTrue(check(hyphenizer.hyphenate("outono"), "ou", "to", "no"));
        Assert.assertTrue(check(hyphenizer.hyphenate("exsudar"), "ex", "su", "dar"));
        Assert.assertTrue(check(hyphenizer.hyphenate("abnegar"), "ab", "ne", "gar"));
        Assert.assertTrue(check(hyphenizer.hyphenate("uruguai"), "u", "ru", "guai"));
        Assert.assertTrue(check(hyphenizer.hyphenate("saúde"), "sa", "ú", "de"));
        Assert.assertTrue(check(hyphenizer.hyphenate("excesso"), "ex", "ces", "so"));
        Assert.assertTrue(check(hyphenizer.hyphenate("gnóstico"), "gnós", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("cooptar"), "co", "op", "tar"));
        Assert.assertTrue(check(hyphenizer.hyphenate("quadrado"), "qua", "dra", "do"));
        Assert.assertTrue(check(hyphenizer.hyphenate("sublime"), "su", "bli", "me"));
        Assert.assertTrue(check(hyphenizer.hyphenate("açafrão"), "a","ça","frão"));
        Assert.assertTrue(check(hyphenizer.hyphenate("deglutir"), "de", "glu", "tir"));
        // Exceptions
        Assert.assertTrue(check(hyphenizer.hyphenate("sublingual"), "sub", "lin", "gual"));
        Assert.assertTrue(check(hyphenizer.hyphenate("abrupto"), "ab", "rup", "to"));
    }

    @Test
    public void testHyphenizeDisyllabic() {
        Assert.assertTrue(check(hyphenizer.hyphenate("casa"), "ca", "sa"));
        Assert.assertTrue(check(hyphenizer.hyphenate("chuva"), "chu", "va"));
        Assert.assertTrue(check(hyphenizer.hyphenate("cacho"), "ca", "cho"));
        Assert.assertTrue(check(hyphenizer.hyphenate("carro"), "car", "ro"));
        Assert.assertTrue(check(hyphenizer.hyphenate("massa"), "mas", "sa"));
        Assert.assertTrue(check(hyphenizer.hyphenate("velho"), "ve", "lho"));
        Assert.assertTrue(check(hyphenizer.hyphenate("sonho"), "so", "nho"));
        Assert.assertTrue(check(hyphenizer.hyphenate("sempre"), "sem", "pre"));
        Assert.assertTrue(check(hyphenizer.hyphenate("nasço"), "nas", "ço"));
        Assert.assertTrue(check(hyphenizer.hyphenate("trevo"), "tre", "vo"));
        Assert.assertTrue(check(hyphenizer.hyphenate("peão"), "pe", "ão"));
        Assert.assertTrue(check(hyphenizer.hyphenate("colchão"), "col", "chão"));
        Assert.assertTrue(check(hyphenizer.hyphenate("lua"), "lu", "a"));
        Assert.assertTrue(check(hyphenizer.hyphenate("dia"), "di", "a"));
        Assert.assertTrue(check(hyphenizer.hyphenate("caí"), "ca", "í"));
        Assert.assertTrue(check(hyphenizer.hyphenate("aí"), "a", "í"));
        Assert.assertTrue(check(hyphenizer.hyphenate("querer"), "que", "rer"));
        Assert.assertTrue(check(hyphenizer.hyphenate("igual"), "i", "gual"));
        Assert.assertTrue(check(hyphenizer.hyphenate("quando"), "quan", "do"));
        Assert.assertTrue(check(hyphenizer.hyphenate("guelra"), "guel", "ra"));
        Assert.assertTrue(check(hyphenizer.hyphenate("casco"), "cas", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("cabra"), "ca", "bra"));
        Assert.assertTrue(check(hyphenizer.hyphenate("saguão"), "sa", "guão"));
        Assert.assertTrue(check(hyphenizer.hyphenate("luau"), "lu", "au"));
    }

    @Test
    public void testHyphenizeMonosyllabic() {
        Assert.assertEquals(1, hyphenizer.hyphenate("ai").size());
        Assert.assertEquals(1, hyphenizer.hyphenate("au").size());
        Assert.assertEquals(1, hyphenizer.hyphenate("uai").size());
        Assert.assertEquals(1, hyphenizer.hyphenate("uau").size());
        Assert.assertEquals(1, hyphenizer.hyphenate("cai").size());
    }

    public boolean check(List<String> syllables, String... check) {
        if (syllables.size() != check.length) {
            return false;
        }

        int i = 0;
        for (String syllableCheck : check) {
            if (!syllables.get(i).equals(syllableCheck)) {
                showDifference(syllables, check);
                return false;
            }
            i++;
        }
        return true;
    }

    private void showDifference(List<String> syllables, String[] check) {
        drawSyllables(syllables);
        System.out.print("Expected: ");
        drawSyllables(check);
    }

    private void drawSyllables(List<String> syllables) {
        int i = 0;
        for (String s : syllables) {
            System.out.print(s);
            i++;
            if (i < syllables.size()) {
                System.out.print("-");
            }
        }
        System.out.print("\n");
    }

    private void drawSyllables(String[] syllables) {
        drawSyllables(Arrays.asList(syllables));
    }

}

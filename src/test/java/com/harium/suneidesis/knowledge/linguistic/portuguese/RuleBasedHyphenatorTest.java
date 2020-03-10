package com.harium.suneidesis.knowledge.linguistic.portuguese;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RuleBasedHyphenatorTest {

    private RuleBasedHyphenator hyphenizer;

    @Before
    public void setUp() {
        hyphenizer = new RuleBasedHyphenator();
    }

    @Test
    public void testHyphenizePolysyllabic() {
        Assert.assertTrue(check(hyphenizer.hyphenate("agnóstico"), "ag", "nós", "ti", "co"));
        Assert.assertTrue(check(hyphenizer.hyphenate("redemoinho"), "re", "de", "mo", "i", "nho"));
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
        Assert.assertTrue(check(hyphenizer.hyphenate("âncora"), "ân", "co", "ra"));
        Assert.assertTrue(check(hyphenizer.hyphenate("moinho"), "mo", "i", "nho"));
        Assert.assertTrue(check(hyphenizer.hyphenate("bainha"), "ba", "i", "nha"));
        Assert.assertTrue(check(hyphenizer.hyphenate("parrilha"), "par", "ri", "lha"));
        Assert.assertTrue(check(hyphenizer.hyphenate("guirlanda"), "guir", "lan", "da"));
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

    private void showDifference(List<String> syllables, String[] check) {
        drawSyllables(syllables);
        System.out.print("Expected: ");
        drawSyllables(Arrays.asList(check));
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

    public boolean check(List<String> syllables, String... check) {
        if (syllables.size() != check.length) {
            showDifference(syllables, check);
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

}

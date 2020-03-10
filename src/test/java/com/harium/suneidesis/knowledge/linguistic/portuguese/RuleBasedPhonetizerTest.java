package com.harium.suneidesis.knowledge.linguistic.portuguese;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Reference: http://www.portaldalinguaportuguesa.org/index.php%3Faction%3Dfonetica%26act%3Dlist%26region%3Dlbx
 */
public class RuleBasedPhonetizerTest {

    private RuleBasedPhonetizer phonetizer;

    @Before
    public void setUp() {
        phonetizer = new RuleBasedPhonetizer();
    }

    @Test
    public void testPhonetizeVowels() {
        Assert.assertTrue(check(phonetizer.phonetize("a"), "a"));
        Assert.assertTrue(check(phonetizer.phonetize("e"), "e"));
        Assert.assertTrue(check(phonetizer.phonetize("i"), "i"));
        Assert.assertTrue(check(phonetizer.phonetize("o"), "o"));
        Assert.assertTrue(check(phonetizer.phonetize("u"), "u"));
    }

    @Test
    public void testPhonetizeNasalVowels() {
        Assert.assertTrue(check(phonetizer.phonetize("ã"), "ã"));
        Assert.assertTrue(check(phonetizer.phonetize("õ"), "õ"));
    }

    @Test
    public void testSimpleSyllables() {
        Assert.assertTrue(check(phonetizer.phonetize("ba"), "b", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("be"), "b", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("bi"), "b", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("bo"), "b", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("bu"), "b", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ca"), "k", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ce"), "s", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ci"), "s", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("co"), "k", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("cu"), "k", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("da"), "d", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("de"), "d", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("di"), "d", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("do"), "d", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("du"), "d", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("fa"), "f", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("fe"), "f", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("fi"), "f", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("fo"), "f", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("fu"), "f", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ga"), "g", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ge"), "j", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("gi"), "j", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("go"), "g", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("gu"), "g", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ha"), "a"));
        Assert.assertTrue(check(phonetizer.phonetize("he"), "e"));
        Assert.assertTrue(check(phonetizer.phonetize("hi"), "i"));
        Assert.assertTrue(check(phonetizer.phonetize("ho"), "o"));
        Assert.assertTrue(check(phonetizer.phonetize("hu"), "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ja"), "j", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("je"), "j", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ji"), "j", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("jo"), "j", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("ju"), "j", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ka"), "k", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ke"), "k", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ki"), "k", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("ko"), "k", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("ku"), "k", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("la"), "l", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("le"), "l", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("li"), "l", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("lo"), "l", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("lu"), "l", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ma"), "m", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("me"), "m", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("mi"), "m", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("mo"), "m", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("mu"), "m", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("na"), "n", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ne"), "n", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ni"), "n", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("no"), "n", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("nu"), "n", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("pa"), "p", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("pe"), "p", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("pi"), "p", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("po"), "p", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("pu"), "p", "u"));

        // Q

        // R (Special Case)
        Assert.assertTrue(check(phonetizer.phonetize("ra"), "r'", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("re"), "r'", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ri"), "r'", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("ro"), "r'", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("ru"), "r'", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("sa"), "s", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("se"), "s", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("si"), "s", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("so"), "s", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("su"), "s", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("ta"), "t", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("te"), "t", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("ti"), "t", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("to"), "t", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("tu"), "t", "u"));

        Assert.assertTrue(check(phonetizer.phonetize("va"), "v", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ve"), "v", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("vi"), "v", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("vo"), "v", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("vu"), "v", "u"));

        // In most cases W sounds like U
        Assert.assertTrue(check(phonetizer.phonetize("wa"), "u", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("we"), "u", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("wi"), "u", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("wo"), "u", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("wu"), "u", "u"));

        // X (Special Case)
        Assert.assertTrue(check(phonetizer.phonetize("za"), "z", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ze"), "z", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("zi"), "z", "i"));
        Assert.assertTrue(check(phonetizer.phonetize("zo"), "z", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("zu"), "z", "u"));
    }

    @Test
    public void testNasalVowels() {
        Assert.assertTrue(check(phonetizer.phonetize("anta"), "ã", "t", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("um"), "ũ"));
        Assert.assertTrue(check(phonetizer.phonetize("âncora"), "ã", "k", "o", "r", "a"));
    }

    @Test
    public void testWordsStartingWithH() {
        Assert.assertTrue(check(phonetizer.phonetize("hoje"), "o", "j", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("hora"), "o", "r", "a"));
    }

    @Test
    public void testWordsWithGFollowingE() {
        Assert.assertTrue(check(phonetizer.phonetize("gelo"), "j", "e", "l", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("girafa"), "j", "i", "r", "a", "f", "a"));
    }

    @Test
    public void testWordsWithR() {
        Assert.assertTrue(check(phonetizer.phonetize("caro"), "k", "a", "r", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("rato"), "r'", "a", "t", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("raro"), "r'", "a", "r", "o"));
    }

    @Test
    public void testWordsWithDoubleR() {
        Assert.assertTrue(check(phonetizer.phonetize("carro"), "c", "a", "r'", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("morro"), "m", "o", "r'", "o"));
    }

    @Test
    public void testWordsWhenSHasPhonemeZ() {
        Assert.assertTrue(check(phonetizer.phonetize("asa"), "a", "z", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("casa"), "k", "a", "z", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("mesa"), "m", "e", "z", "a"));
    }

    @Test
    public void testWordsWithDoubleS() {
        Assert.assertTrue(check(phonetizer.phonetize("passa"), "p", "a", "s", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("missô"), "m", "i", "s", "ô"));
    }

    @Test
    public void testWordsWithConsonantsInTheSameSyllable() {
        Assert.assertTrue(check(phonetizer.phonetize("treze"), "t", "r", "e", "z", "e"));
    }

    @Test
    public void testWordsWithCedil() {
        Assert.assertTrue(check(phonetizer.phonetize("caça"), "k", "a", "s", "a"));
    }

    @Test
    public void testWordsWithQ() {
        Assert.assertTrue(check(phonetizer.phonetize("quase"), "k", "u", "a", "z", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("quina"), "k", "i", "n", "a"));
    }

    /**
     * Reference: https://www.normaculta.com.br/palavras-com-x/
     */
    @Test
    public void testWordsWhenXHasPhonemeCH() {
        Assert.assertTrue(check(phonetizer.phonetize("baixo"), "b", "a", "i", "ch", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("enxergar"), "ẽ", "ch", "e", "r", "g", "a", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("enxerido"), "ẽ", "ch", "e", "r", "i", "d", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("enxugar"), "ẽ", "ch", "u", "g", "a", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("faixa"), "f", "a", "i", "ch", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("lixo"), "l", "i", "ch", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("mexer"), "m", "e", "ch", "e", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("puxar"), "p", "u", "ch", "a", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("taxa"), "t", "a", "ch", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("xingar"), "ch", "ĩ", "g", "a", "r"));

        Assert.assertTrue(check(phonetizer.phonetize("bruxa"), "b", "r", "u", "ch", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("frouxa"), "f", "r", "o", "u", "ch", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("frouxo"), "f", "r", "o", "u", "ch", "o"));
    }

    @Test
    public void testWordsWhenXHasPhonemeKS() {
        Assert.assertTrue(check(phonetizer.phonetize("anexo"), "a", "n", "e", "ks", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("axila"), "a", "ks", "i", "l", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("axioma"), "a", "ks", "i", "o", "m", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("complexo"), "c", "õ", "p", "l", "e", "ks", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("convexo"), "c", "õ", "v", "e", "ks", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("fluxo"), "f", "l", "u", "ks", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("táxi"), "t", "á", "ks", "i"));
    }

    @Test
    public void testWordsWhenXHasPhonemeS() {
        Assert.assertTrue(check(phonetizer.phonetize("texto"), "t", "e", "s", "t", "o"));
    }

    @Test
    public void testWordsWhenXHasPhonemeZ() {
        Assert.assertTrue(check(phonetizer.phonetize("exato"), "e", "z", "a", "t", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("exame"), "e", "z", "a", "m", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("exercício"), "e", "z", "e", "r", "s", "í", "s", "i", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("exonerar"), "e", "z", "o", "n", "e", "r", "a", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("êxodo"), "e", "z", "o", "d", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("êxito"), "e", "z", "i", "t", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("exímio"), "e", "z", "í", "m", "i", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("exótico"), "e", "z", "ó", "t", "i", "k", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("exequível"), "e", "z", "e", "k", "í", "v", "e", "l"));
    }

    @Test
    public void testWordsWithDigraph() {
        Assert.assertTrue(check(phonetizer.phonetize("calha"), "k", "a", "lh", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("minha"), "m", "i", "nh", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("ilha"), "i", "lh", "a"));
        Assert.assertTrue(check(phonetizer.phonetize("chocolate"), "ch", "o", "k", "o", "l", "a", "t", "e"));
        Assert.assertTrue(check(phonetizer.phonetize("exceder"), "e", "xc", "e", "d", "e", "r"));
        Assert.assertTrue(check(phonetizer.phonetize("excelente"), "e", "xc", "e", "l", "ẽ", "t", "e"));
    }

    @Test
    public void testWordsWithAccute() {
        Assert.assertTrue(check(phonetizer.phonetize("índio"), "ĩ", "d", "i", "o"));
    }

    @Test
    public void testWordsWithTilde() {
        Assert.assertTrue(check(phonetizer.phonetize("cão"), "c", "ã", "o"));
        Assert.assertTrue(check(phonetizer.phonetize("maçã"), "m", "a", "s", "ã"));
    }

    @Test
    public void testBigWords() {
        Assert.assertTrue(check(phonetizer.phonetize("paralelepípedo"), "p", "a", "r","a","l","e","l","e","p","í","p","e","d","o"));
    }

    @Test
    public void testSyllabicPhonetize() {
        Assert.assertTrue(check(phonetizer.syllabicPhonetize("razão"), "r'a", "zão"));
        Assert.assertTrue(check(phonetizer.syllabicPhonetize("redemoinho"), "r'e", "de", "mo", "i", "nho"));
    }

    public boolean check(List<String> list, String... check) {
        if (list.size() != check.length) {
            showDifference(list, check);
            return false;
        }

        int i = 0;
        for (String syllableCheck : check) {
            if (!list.get(i).equals(syllableCheck)) {
                showDifference(list, check);
                return false;
            }
            i++;
        }

        return true;
    }

    private void showDifference(List<String> syllables, String[] check) {
        drawPhonemes(syllables);
        System.out.print("Expected: \n");
        drawPhonemes(Arrays.asList(check));
    }

    private void drawPhonemes(List<String> syllables) {
        for (String s : syllables) {
            System.out.print("/");
            System.out.print(s);
            System.out.print("/ ");
        }
        System.out.print("\n");
    }
}

package algorithms.java.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKnuthMorrisPratt {
  @Test
  public void testKMP1() {
    String S = "xabc";
    String W = "abc";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(1, kmp.findMatch(S));
  }

  @Test
  public void testKMP2() {
    String S = "xabc";
    String W = "foo";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(-1, kmp.findMatch(S));
  }

  @Test
  public void testKMP3() {
    String S = "xfobarfoo";
    String W = "foo";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(6, kmp.findMatch(S));
  }

  @Test
  public void testKMP4() {
    String S = "xbarfoofoo";
    String W = "foofoo";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(4, kmp.findMatch(S));
  }

  @Test
  public void testKMP5() {
    String S = "bacbababaabcbab";
    String W = "ababaca";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(-1, kmp.findMatch(S));
  }

  @Test
  public void testKMP6() {
    String S = "ABC ABCDAB ABCDABCDABDE";
    String W = "ABCDABD";
    KnuthMorrisPratt kmp = new KnuthMorrisPratt(W);
    System.out.println(kmp);
    assertEquals(15, kmp.findMatch(S));
  }
}

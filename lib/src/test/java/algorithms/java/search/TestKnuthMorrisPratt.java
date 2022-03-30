package algorithms.java.search;

import org.junit.jupiter.api.Test;

import static algorithms.java.search.KnuthMorrisPratt.findMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKnuthMorrisPratt {
  @Test
  public void testKMP1() {
    String S = "xabc";
    String W = "abc";
    assertEquals(1, findMatch(S, W));
  }

  @Test
  public void testKMP2() {
    String S = "xabc";
    String W = "foo";
    assertEquals(-1, findMatch(S, W));
  }

  @Test
  public void testKMP3() {
    String S = "xfobarfoo";
    String W = "foo";
    assertEquals(6, findMatch(S, W));
  }

}

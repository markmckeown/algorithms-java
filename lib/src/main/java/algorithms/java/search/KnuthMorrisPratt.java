package algorithms.java.search;

import java.util.ArrayList;

/**
 * Knuth–Morris–Pratt string-searching algorithm (or KMP algorithm) searches
 * for occurrences of a "word" W within a main "text string" S by employing the
 * observation that when a mismatch occurs, the word itself embodies sufficient
 * information to determine where the next match could begin, thus bypassing
 * re-examination of previously matched characters.
 *
 * Find the first occurance of W in S, if not found then return -1.
 */
public class KnuthMorrisPratt {
  private final ArrayList<Integer> T;
  private final String W;

  public KnuthMorrisPratt(final String W) {
    this.W = W;
    this.T = new ArrayList<>(W.length());
    for (int i = 0; i < W.length(); i++) {
      T.add(0);
    }
    T.set(0,-1);

    // Populate the lookup table based on the Word we are searching for.
    // As we progress through the S looking for W if we start
    // getting a hit for W and fail rather than re-wind we can use
    // this table to reset our state. This avoids rewinding the back
    // into S.
    int pos = 1;
    int cnd = 0;
    while (pos < W.length()) {
      if (W.charAt(pos) == W.charAt(cnd)) {
        T.set(pos, T.get(cnd));
      } else {
        T.set(pos, cnd);
        while (cnd >= 0 && W.charAt(pos) != W.charAt(cnd)) {
          cnd = T.get(cnd);
        }
      }
      pos++;
      cnd++;
    }
  }


  public int findMatch(String S) {
    int ret = -1;

    // Now search S for W.
    int j = 0;
    int k = 0;
    while (j < S.length()) {
      if (W.charAt(k) == S.charAt(j)) {
        j++; k++;
        if (k == W.length()) {
          ret = j - k;
          return ret;
        }
      } else {
        k = T.get(k);
        if (k < 0) {
          j++; k++;
        }
      }
    }
    return ret;
  }

  @Override
  public String toString() {
    String res=  "KnuthMorrisPratt{" +
        " W=\"" + W +"\"\n";

    for(int i = 0; i < T.size(); i++) {
      res += i + " : " + W.charAt(i) + " : " + T.get(i) + "\n";
    }

    res += '}';
    return res;
  }
}

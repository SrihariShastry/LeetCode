package com.leetcode.Companies.Uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The Idea behind the solution are the following considerations:
 * 1. We cannot produce a palindrome if there are more then one characters with odd count
 * in the string
 * 2. We can intelligently produce a palindrome permutation of the String by only generating
 * the first half of the final palindrome, and appending the reverse of the first half
 * <p>
 * "map" is an integer array which keeps count of all the 128 ASCII characters that may appear in the string
 * "st" is a character array which keeps half of the characters from the original String
 * "ch" is the character which appears odd number of times. Since we can have only one character appear
 * odd number of times to generate a valid palindrome permutation,
 * we just store the odd character in a variable.
 */
public class PalindromePermutation {
    Set<String> res;

    public List<String> generatePalindromes(String s) {
        char ch = 0;
        int k = 0;
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        //check if permutations are possible
        if (!canPermute(s, map)) return new ArrayList<>();

        res = new HashSet<>();

        //build the st char array
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 != 0)
                ch = (char) i;
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char) i;
            }
        }

        //build permutations
        permute(st, 0, ch);

        return new ArrayList<>(res);
    }

    public boolean canPermute(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 != 0)
                count++;
            else
                count--;
        }
        return count <= 1;
    }

    /**
     * we check if l == s.length if yes, then form the palindrome string and put it in the set
     * if not, then replace character at l with every other character in the array and
     * recursively call permute function
     *
     * @param s  char array of half the characters from the initial string
     * @param l  current position of permutation
     * @param ch the character which appears odd number of times (if it exists)
     */
    public void permute(char[] s, int l, char ch) {

        if (l == s.length) {
            res.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuilder(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (i == l || s[i] != s[l]) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i);
                }
            }
        }
    }

    public void swap(char[] st, int s, int e) {
        char temp = st[s];
        st[s] = st[e];
        st[e] = temp;
    }
}

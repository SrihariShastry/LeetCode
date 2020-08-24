package com.leetcode.top75.Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {

            Set<Character> charSet = new HashSet<>();
            int i=0,j=0,longest=0;
            while(i<s.length()&&j<s.length()){
                if(!charSet.contains(s.charAt(j))){
                    charSet.add(s.charAt(j++));
                    longest=Math.max(longest,j-i);
                }else{
                    charSet.remove(s.charAt(i++));
                }

            }
            return longest;

        }
    }

    public class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length(), ans = 0;
            Map<Character, Integer> map = new HashMap<>(); // current index of character
            // try to extend the range [i, j]
            for (int j = 0, i = 0; j < n; j++) {
                if (map.containsKey(s.charAt(j))) {
                    i = Math.max(map.get(s.charAt(j)), i);
                }
                ans = Math.max(ans, j - i + 1);
                map.put(s.charAt(j), j + 1);
            }
            return ans;
        }
    }
}

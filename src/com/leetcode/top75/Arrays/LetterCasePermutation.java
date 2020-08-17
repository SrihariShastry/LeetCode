package com.leetcode.top75.Arrays;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {
    class Solution {
        public List<String> letterCasePermutation(String S) {
            List<String> res = new LinkedList<>();
            dfs(S.toCharArray(),0,res);
            return res;

        }
        public void dfs(char[] ch,int pos, List<String> res){
            if(pos>=ch.length){
                res.add(new String(ch));
                return;
            }

            if(Character.isDigit(ch[pos])){
                dfs(ch,pos+1,res);
                return;
            }

            ch[pos]=Character.toUpperCase(ch[pos]);
            dfs(ch,pos+1,res);

            ch[pos]=Character.toLowerCase(ch[pos]);
            dfs(ch,pos+1,res);

        }
    }
}

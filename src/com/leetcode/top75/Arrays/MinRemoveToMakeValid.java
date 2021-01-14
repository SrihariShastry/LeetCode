package com.leetcode.top75.Arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinRemoveToMakeValid {
    class Solution1 {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> stack = new Stack<>();
            Set<Integer> rem = new HashSet<>();

            // char[] charArr= s.toCharArray();
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='(')
                    stack.push(i);
                if(s.charAt(i)==')'){
                    if(!stack.isEmpty())stack.pop();
                    else rem.add(i);
                }

            }
            while(!stack.isEmpty()){
                rem.add(stack.pop());
            }
            StringBuilder str=new StringBuilder();
            int j=0;
            for(int i=0;i<s.length();i++){
                if(!rem.contains(i))
                    str.append(s.charAt(i));
            }
            return str.toString();

        }
    }
    class Solution2 {
        public String minRemoveToMakeValid(String s) {
            char[] c = new char[s.length()];
            c= s.toCharArray();
            int left =0;
            for(int i=0;i<c.length;i++){
                if(c[i]=='(')
                    left++;
                else if(c[i]==')'){
                    if(left==0)
                        c[i]='0';
                    else
                        left--;
                }
            }
            int j=c.length-1;
            while(left>0){
                if(c[j]=='('){
                    c[j]='0';
                    left--;
                }
                j--;

            }
            StringBuilder sb = new StringBuilder();
            for(char a:c){
                if(a!='0')
                    sb.append(a);
            }
            return sb.toString();

        }
    }
}

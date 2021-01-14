package com.leetcode.top75.Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public static void main(String[] args) {

        String[] inputs = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(inputs));
    }

    public static int numUniqueEmails(String[] emails) {

        Set<String> res = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean dom=false;
            boolean splChar=false;
            for(int i=0;i<email.length();i++){
                if(dom){
                    sb.append(email.charAt(i));
                    continue;
                }

                if(email.charAt(i)=='@'){
                    dom=true;
                    sb.append(email.charAt(i));
                    continue;
                }
                if(splChar)continue;

                if (email.charAt(i) != '.' && email.charAt(i) != '+') {
                    sb.append(email.charAt(i));
                }
                if (email.charAt(i) == '+')
                    splChar = true;

            }
            res.add(sb.toString());
        }
        return res.size();
    }

}

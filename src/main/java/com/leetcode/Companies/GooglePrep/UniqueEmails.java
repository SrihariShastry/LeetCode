package com.leetcode.Companies.GooglePrep;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {

        Set<String> uniqueEmails = new HashSet<>();

        for (String email : emails) {
            String[] split = email.split("@");
            split[0] = split[0].replaceAll("[.]", "");
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < split[0].length()) {
                if (split[0].charAt(i) == '+') {
                    break;
                } else {
                    sb.append(split[0].charAt(i));
                }
                i++;
            }
            sb.append("@");
            sb.append(split[1]);
            uniqueEmails.add(sb.toString());
        }
        return uniqueEmails.size();
    }
}

package com.leetcode.Companies.Amazon;

import java.util.ArrayList;
import java.util.List;

public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLog = new ArrayList<>();
        List<String> numLog = new ArrayList<>();

        for (String log : logs) {
            String[] s = log.split(" ", 2);
            if (Character.isDigit(s[1].charAt(0))) {
                numLog.add(log);
            } else {
                letterLog.add(log);
            }
        }

        letterLog.sort((o1, o2) -> {
            String id1 = o1.split(" ", 2)[0];
            String id2 = o2.split(" ", 2)[0];
            int comp = o1.substring(id1.length()).compareTo(o2.substring(id2.length()));
            if (comp == 0) {
                return id1.compareTo(id2);
            } else
                return comp;
        });

        letterLog.addAll(numLog);
        return letterLog.toArray(new String[letterLog.size()]);
    }
}

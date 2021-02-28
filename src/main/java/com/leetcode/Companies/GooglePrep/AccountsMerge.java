package com.leetcode.Companies.GooglePrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, String> owner = new HashMap<>();
        HashMap<String, HashSet<String>> unions = new HashMap<>();

        for (List<String> acc : accounts) {
            String user = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                parent.put(acc.get(i), acc.get(i));
                owner.put(acc.get(i), user);
            }
        }
        for (List<String> acc : accounts) {
            String p = find(acc.get(1), parent);
            for (int i = 2; i < acc.size(); i++) {
                parent.put(find(acc.get(i), parent), p);
            }
        }
        for (List<String> acc : accounts) {
            String p = find(acc.get(1), parent);
            for (int i = 1; i < acc.size(); i++) {
                unions.putIfAbsent(p, new HashSet<>());
                unions.get(p).add(acc.get(i));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (String key : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(key));
            emails.sort(String::compareTo);
            emails.add(0, owner.get(key));
            res.add(emails);
        }

        return res;

    }

    public String find(String a, HashMap<String, String> parent) {
        return parent.get(a).equals(a) ? a : find(parent.get(a), parent);
    }
}

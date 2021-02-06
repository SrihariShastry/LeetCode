package com.leetcode.Companies.Amazon;


import java.util.*;

class Pair {
    String web;
    int time;

    public Pair(String web, int time) {
        this.web = web;
        this.time = time;
    }
}

public class MostVisitedPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> stat = new HashMap<>();

        Map<String, Integer> count = new HashMap<>();

        //categorize all the websites that a user has visited

        for (int i = 0; i < username.length; i++) {
            stat.putIfAbsent(username[i], new ArrayList<>());
            stat.get(username[i]).add(new Pair(website[i], timestamp[i]));
        }

        //for each user, get all the websites visited and sort it according to timestamp
        //loop through each 3-tuple combination of the list and count the number of times
        //we have encountered the 3-tuple combination
        //keep res updated with the most count
        String res = "";
        for (String key : stat.keySet()) {
            Set<String> visited = new HashSet<>();
            List<Pair> websites = stat.get(key);
            websites.sort(Comparator.comparingInt(a -> a.time));
            int n = websites.size();
            for (int i = 0; i < n; i++)
                for (int j = i + 1; j < n; j++)
                    for (int k = j + 1; k < n; k++) {
                        String str = websites.get(i).web + " "
                                + websites.get(j).web + " "
                                + websites.get(k).web;

                        if (!visited.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            visited.add(str);
                        }

                        if (res.isEmpty() || count.get(res) < count.get(str) ||
                                (count.get(res).equals(count.get(str)) && res.compareTo(str) > 0))
                            res = str;
                    }
        }
        return Arrays.asList(res.split(" "));
    }
}

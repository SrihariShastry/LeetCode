package com.leetcode.Companies.Uber;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> adj = new HashMap<>();
        double[] res = new double[queries.size()];
        //build adjacency Map
        int i = 0;
        for (List<String> eq : equations) {
            String start = eq.get(0);
            String end = eq.get(1);
            double value = values[i++];
            if (!adj.containsKey(start))
                adj.put(start, new HashMap<>());
            if (!adj.containsKey(end))
                adj.put(end, new HashMap<>());

            adj.get(start).put(end, value);
            adj.get(end).put(start, 1 / value);
        }
        i = 0;
        for (List<String> query : queries) {
            Set<String> visited = new HashSet<>();
            if (!adj.containsKey(query.get(0)) || !adj.containsKey(query.get(1)))
                res[i] = -1;
            else if (query.get(0).equals(query.get(1)))
                res[i] = 1;
            else
                res[i] = dfs(query.get(0), query.get(1), 1, adj, visited);
            i++;
        }
        return res;
    }

    public double dfs(String src, String dst, double val, Map<String, Map<String, Double>> adj
            , Set<String> visited) {
        double ret = -1.0;
        visited.add(src);
        Map<String, Double> neighbour = adj.get(src);
        if (neighbour.containsKey(dst))
            ret = val * neighbour.get(dst);
        else {
            for (Map.Entry<String, Double> n : neighbour.entrySet()) {
                if (visited.contains(n.getKey()))
                    continue;
                ret = dfs(n.getKey(), dst, val * n.getValue(), adj, visited);
                if (ret != -1)
                    break;
            }
        }
        return ret;
    }
}

package com.leetcode.Uber;

import java.sql.SQLOutput;
import java.util.*;

public class FindItinerary {

    /*
     *
     * Time Complexity: Average Case O(|E|+|E| log(|E|/|V|); worst Case: |N|log|N| where N is |E|/2;
     * Explanation: Teh DFS function traverses evert edge only once and hence the time complexity of
     * graph traversal is |E|.
     * However, Complexity of sorting adjacency list of every vertex is going to be a bit tricky
     * The worst case(Star-like graph) is when there are M Vertices and E edges,
     * and "JFK" is like a cluster's center/Centroid of sorts
     * which means that the JFK is going to be the center for all other vertices.
     * In this case JFK's adjacency list is going to have |E|/2 number of vertices
     * with the rest of the half being the return tickets from other airports.
     * Then, the sorting of JFK is going to become the costliest Which is NlogN where N=|E|/2;
     *
     * Average case is when its a Mesh Network with every node having a route to every other node
     * except itself in which case the sorting time complexity reduces to |E|*log(|E|/|V|);
     *
     * */
    HashMap<String, LinkedList<String>> adj = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            LinkedList<String> t = adj.getOrDefault(ticket.get(0), new LinkedList<>());
            t.add(ticket.get(1));
            adj.put(ticket.get(0), t);
        }

        adj.forEach((key, value) -> Collections.sort(value));
        dfs("JFK");
        return res;
    }

    public void dfs(String src) {
        if (adj.containsKey(src)) {
            LinkedList<String> destList = adj.get(src);
            while (!destList.isEmpty()) {
                dfs(destList.pollFirst());
            }
        }
        res.offerFirst(src);
    }

}

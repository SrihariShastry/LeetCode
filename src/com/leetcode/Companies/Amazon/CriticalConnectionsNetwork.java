package com.leetcode.Companies.Amazon;

import java.util.*;

/**
 * This solution uses DFS with a rank array that keeps track of the order in which the nodes
 * are visited.
 * if rank of the neighbour node is equal to current Node's rank -1, then it means that
 * we had visited the node previously and that makes this node a parent of the current node.
 * since parent is already discovered or is being currently discovered, we ignore it
 * <p>
 * If the rank of the neighbour is less than the rank of the current node, then that means
 * the neighbour is connected to a parent node of the current node through some other path
 * and when this condition is hit, we remove all the connections between
 * the current node and the neighbour node deciding that they are involved in a cycle
 * <p>
 * In the end, we are left with connections that are critical/ connections that are not
 * involved in a cycle.
 * <p>
 * We simply return the remaining list of connections since they are the critical connections
 */
public class CriticalConnectionsNetwork {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashSet<List<Integer>> conSet = new HashSet<>(connections);
        int[] rank = new int[n];
        Arrays.fill(rank, -2);
        //build the adjacency (will be a bidirectional graph)
        for (List<Integer> conn : connections) {
            adj.putIfAbsent(conn.get(0), new ArrayList<>());
            adj.putIfAbsent(conn.get(1), new ArrayList<>());
            adj.get(conn.get(0)).add(conn.get(1));
            adj.get(conn.get(1)).add(conn.get(0));
        }
        //adjacency graph, current node, depth of current node, rank array, set of connections
        dfs(adj, 0, 0, rank, conSet);

        return new ArrayList<>(conSet);
    }

    public int dfs(HashMap<Integer, List<Integer>> adj, int node,
                   int depth, int[] rank, HashSet<List<Integer>> conSet) {

        //already visited node
        if (rank[node] >= 0)
            return rank[node];

        rank[node] = depth;
        int minDepth = depth;
        for (int neighbor : adj.get(node)) {
            //if depth of neighbour is depth-1 then it means
            // that it was already visited previously
            // and it is the parent of the current node
            if (rank[neighbor] == depth - 1)
                continue;
            int minDepthNeighbour = dfs(adj, neighbor, depth + 1, rank, conSet);
            minDepth = Math.min(minDepth, minDepthNeighbour);
            if (minDepthNeighbour <= depth) {
                //remove connections since it's involved in a cycle
                conSet.remove(Arrays.asList(node, neighbor));
                conSet.remove(Arrays.asList(neighbor, node));
            }
        }

        return minDepth;
    }
}

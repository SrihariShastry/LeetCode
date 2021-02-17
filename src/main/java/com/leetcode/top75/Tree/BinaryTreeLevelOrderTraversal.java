package com.leetcode.top75.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        bfs(root, 0);

        for (List<Integer> l : map.values()) {
            res.add(l);
        }
        return res;
    }

    public void bfs(TreeNode t, int level) {

        if (t == null) return;

        List<Integer> nodes = map.getOrDefault(level, new ArrayList<>());

        nodes.add(t.val);
        map.put(level, nodes);

        bfs(t.left, level + 1);
        bfs(t.right, level + 1);
    }

}

package com.leetcode.Companies.Amazon;

import com.leetcode.top75.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZigZagTraversal {
    HashMap<Integer, List<Integer>> levels;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levels = new HashMap<>();

        bfs(root, 0);
        return new ArrayList<>(levels.values());
    }

    public void bfs(TreeNode root, int level) {
        if (root == null) return;

        if (!levels.containsKey(level)) {
            levels.put(level, new ArrayList<>());
            levels.get(level).add(root.val);
        } else if (level % 2 == 0) {
            levels.get(level).add(root.val);
        } else {
            levels.get(level).add(0, root.val);
        }

        if (root.left != null) {
            bfs(root.left, level + 1);
        }
        if (root.right != null) {
            bfs(root.right, level + 1);
        }
    }
}

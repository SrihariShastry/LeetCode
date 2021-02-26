package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.Tree.TreeNode;

import java.util.HashMap;
import java.util.List;

public class DuplicateSubtrees {
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root, new HashMap<>());

        return res;
    }

    public String helper(TreeNode node, HashMap<String, Integer> map) {
        if (node == null) return "#";

        String key = node.val + "," + helper(node.left, map) + "," + helper(node.right, map);
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) res.add(node);
        return key;
    }
}


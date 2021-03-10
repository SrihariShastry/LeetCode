package com.leetcode.Companies.DataBricks;

import com.leetcode.top75.Tree.TreeNode;

import java.util.*;

public class ClosestLeafNode {

    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public int findClosestLeaf(TreeNode root, int k) {
        //find the node with val k
        //keep track of all nodes above K for cases where in the closest leaf is the path through parent
        TreeNode target = findK(root, k);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(target);
        Set<Integer> visited = new HashSet<>();

        while (!q.isEmpty()) {
            TreeNode t = q.poll();

            if (t.left == null && t.right == null)
                return t.val;

            if (t.left != null && visited.add(t.left.val)) {
                q.add(t.left);
            }
            if (t.right != null && visited.add(t.right.val)) {
                q.add(t.right);
            }
            //check for leaf through parent path
            if (map.containsKey(t) && visited.add(map.get(t).val)) {
                q.add(map.get(t));
            }
        }
        return -1;
    }

    public TreeNode findK(TreeNode root, int k) {
        if (root.val == k) return root;

        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = findK(root.left, k);
            if (left != null)
                return left;
        }

        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = findK(root.right, k);
            return right;
        }
        return null;
    }
}

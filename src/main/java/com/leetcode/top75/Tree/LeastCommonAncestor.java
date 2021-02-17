package com.leetcode.top75.Tree;

public class LeastCommonAncestor {
    TreeNode ans = null;

    public TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        traverse(root, p, q);

        return ans;
    }

    public boolean traverse(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return false;

        int left = traverse(root.left, p, q) ? 1 : 0;
        int right = traverse(root.right, p, q) ? 1 : 0;

        int mid = (root == p || root == q) ? 1 : 0;

        if (left + right + mid >= 2)
            ans = root;

        return (left + right + mid) > 0;
    }
}

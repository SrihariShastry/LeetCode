package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.Tree.TreeNode;

public class BinaryTreeColoringGame {
    int val;
    int left;
    int right;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        val = x;
        count(root);

        return Math.max(Math.max(left, right), n - left - right - 1) > n / 2;
    }

    private int count(TreeNode root) {
        if (root == null) return 0;
        int l = count(root.left);
        int r = count(root.right);
        if (root.val == val) {
            left = l;
            right = r;
        }
        return l + r + 1;
    }
}

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

    /**
     * count will recursively count the number of nodes,
     * in the left and in the right.
     * n - left - right will be the number of nodes in the "subtree" of parent.
     * Now we just need to compare max(left, right, parent) and n / 2
     *
     * @param root root node
     * @return the count of nodes under root
     */
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

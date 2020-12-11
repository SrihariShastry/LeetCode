package com.leetcode.Uber;

import com.leetcode.top75.Tree.TreeNode;

public class RecoverBinarySearchTree {
    TreeNode first = null;
    TreeNode sec = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = first.val;
        first.val = sec.val;
        sec.val = temp;
    }

    public void traverse(TreeNode root) {

        if (root == null) return;

        traverse(root.left);

        if (first == null && (prev == null || prev.val >= root.val)) {
            first = prev;
        }
        if (first != null && (prev.val >= root.val)) {
            sec = root;
        }

        prev = root;

        traverse(root.right);
    }

}

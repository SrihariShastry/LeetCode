package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.Tree.TreeNode;

public class FlipEquiBinaryTree {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
    }
}

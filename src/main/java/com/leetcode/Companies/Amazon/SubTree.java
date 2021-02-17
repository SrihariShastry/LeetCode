package com.leetcode.Companies.Amazon;

import com.leetcode.top75.Tree.TreeNode;

public class SubTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;

        if (t.val != s.val) return false;

        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

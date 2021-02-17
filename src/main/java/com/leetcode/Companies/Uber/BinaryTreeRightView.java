package com.leetcode.Companies.Uber;

import com.leetcode.top75.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    /**
     * this function keeps going right. and if there is no right node, then it starts going left
     * a new val is added only if the current level has not been explored
     *
     * @param root  the node
     * @param res   the result array list
     * @param depth current depth of traversal
     */
    public void helper(TreeNode root, List<Integer> res, int depth) {

        if (root == null)
            return;
        if (res.size() == depth) {
            res.add(root.val);
        }

        helper(root.right, res, depth + 1);
        helper(root.left, res, depth + 1);
    }
}

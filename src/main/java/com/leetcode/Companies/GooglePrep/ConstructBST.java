package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.Tree.TreeNode;

import java.util.HashMap;

public class ConstructBST {

    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(0, 0, inorder.length - 1, preorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder) {

        if (preStart > preorder.length - 1 || inStart > inEnd) return null;

        int inIndex = map.getOrDefault(preorder[preStart], -1);
        TreeNode root = new TreeNode(preorder[preStart]);
        if (inIndex != -1) {
            root.left = helper(preStart + 1, inStart, inIndex - 1, preorder);
            root.right = helper(preStart + 1 + inIndex - inStart, inIndex + 1, inEnd, preorder);
        }

        return root;

    }
}

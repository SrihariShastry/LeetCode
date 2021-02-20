package com.leetcode.Companies.Amazon;

import com.leetcode.top75.Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTree {

    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return helper(0, 0, inorder.length - 1, preorder);
    }

    /**
     * @param preStart The index where we get the current root
     * @param inStart  boundaries for each node
     * @param inEnd    boundaries for each node
     * @param preorder array of preorder of elements
     * @return the root node
     */
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder) {

        if (inStart > inEnd || preStart > preorder.length - 1)
            return null;

        //construct the root for the current tree
        TreeNode root = new TreeNode(preorder[preStart]);

        //need to set left and right nodes
        //where is the root located in the inorder array? coz inorder is left root right
        int inIndex = inorderMap.get(root.val);

        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder);

        // there may be left subtrees so we need to traverse those
        // before getting to the right node
        // inStart to inIndex is the number of elements
        // that will come on the left of this root so we say
        // preStart(the current root) + inIndex - inStart(all the elements on the left subtree) + 1(the right node)
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder);

        return root;

    }
}

package com.leetcode.Companies.Amazon;

import com.leetcode.top75.Tree.TreeNode;

public class InorderSuccessor {
    /**
     * Inorder traversal of a BST gives us the sorted order of nodes.
     * Simply put inorder successor of a node is the node
     * that is just greater than the current node
     * <p>
     * We only keep the parent node reference when we are going left because
     * the root node is the inorder successor of its left child.
     * <p>
     * the right most child will have no successor since it's the largest element in the tree
     *
     * @param root Root of the tree
     * @param p    Node whose inorder successor has to be found
     * @return return the inorder successor node of p
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode res = null;
        TreeNode cur = root;

        while (cur != null) {

            if (cur.val > p.val) {
                //Node P lies on the left side of the tree
                res = cur;
                cur = cur.left;
            } else {
                //Node is current node or it lies on the right side
                cur = cur.right;
            }
        }
        return res;
    }
}

package com.leetcode.Companies.GooglePrep;

import com.leetcode.top75.Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    List<TreeNode> res;

    /**
     * All tree problems should be first tried with recursion.
     * simple concept of recursion is that you need to care about the current node and apply rules for the current node
     * and have that repeat for all sub nodes
     * <p>
     * In our problem, we say that if current node is not to be deleted and if it's the root node, then add the node to res
     * if the node is to be deleted then its children will be marked as root nodes then it follows in the sub nodes as well
     *
     * @param root      Root node
     * @param to_delete node values to be deleted
     * @return Forest of nodes after removal
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> del = new HashSet<>();
        res = new ArrayList<>();
        for (int d : to_delete) {
            del.add(d);
        }
        helper(root, del, true);
        return res;
    }

    public TreeNode helper(TreeNode node, Set<Integer> del, boolean isRoot) {
        if (node == null) return null;

        boolean deleted = del.contains(node.val);
        if (isRoot && !deleted) res.add(node);

        node.left = helper(node.left, del, deleted);
        node.right = helper(node.right, del, deleted);

        return deleted ? null : node;
    }
}

package com.leetcode.Uber;

import com.leetcode.top75.Tree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public String rSerialize(TreeNode root, String val) {
        if (root == null) {
            val += "null,";
            return val;
        }

        val += root.val + ",";
        val = rSerialize(root.left, val);
        val = rSerialize(root.right, val);

        return val;
    }

    // Decodes a tree to a single string.
    public TreeNode deserialize(String data) {
        return rDeserialize(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    public TreeNode rDeserialize(List<String> data) {
        if (data.get(0).equals("null")) {
            data.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.get(0)));
        data.remove(0);
        root.left = rDeserialize(data);
        root.right = rDeserialize(data);

        return root;
    }
}

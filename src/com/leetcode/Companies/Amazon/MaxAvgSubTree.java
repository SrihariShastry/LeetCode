package com.leetcode.Companies.Amazon;

import com.leetcode.top75.Tree.TreeNode;

public class MaxAvgSubTree {

    public double maximumAverageSubtree(TreeNode root) {
        return helper(root)[2];
    }

    public double[] helper(TreeNode root) {
        //0: sum
        //1: count
        //2: average
        if (root == null)
            return new double[]{0, 0, 0};

        double[] left = helper(root.left);
        double[] right = helper(root.right);

        double count = left[1] + right[1] + 1;
        double sum = left[0] + right[0] + root.val;
        double childAvg = Math.max(left[2], right[2]);
        return new double[]{sum, count, Math.max(childAvg, sum / count)};
    }
}

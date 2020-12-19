package com.leetcode.Companies.Uber;

public class ConstructQuadTree {

    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    class Solution {

        Node root = null;

        public Node construct(int[][] grid) {
            return helper(0, grid.length, 0, grid[0].length, grid);
        }

        private Node helper(int rowStart, int rowEnd, int colStart, int colEnd, int[][] grid) {

            if (rowEnd - rowStart == 1) {
                return new Node(grid[rowStart][colStart] == 1, true);
            }

            int rowMid = rowStart + (rowEnd - rowStart) / 2;
            int colMid = colStart + (colEnd - colStart) / 2;

            Node topLeft = helper(rowStart, rowMid, colStart, colMid, grid);
            Node topRight = helper(rowStart, rowMid, colMid, colEnd, grid);
            Node bottomLeft = helper(rowMid, rowEnd, colStart, colMid, grid);
            Node bottomRight = helper(rowMid, rowEnd, colMid, colEnd, grid);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                    topLeft.val == topRight.val && topLeft.val == bottomLeft.val &&
                    topLeft.val == bottomRight.val) {
                /**
                 * If all nodes are leaf nodes and all their values are same
                 * then we combine these 4 and represent it as one.
                 */
                return new Node(topLeft.val, true);
            }
            /**
             * if all are not 1's then this node is not gonna be a leaf node
             * and we link top left bottom right nodes and make this a parent node
             */

            return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
        }
    }
}

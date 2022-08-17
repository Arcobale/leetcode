import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /*
         * int leftValue = sumOfLeftLeaves(root.left); // 左
         * int rightValue = sumOfLeftLeaves(root.right); // 右
         * int midValue = 0;
         * if (root.left != null && root.left.left == null && root.left.right == null) {
         * midValue = root.left.val;
         * }
         * return leftValue + rightValue + midValue; // 中
         */
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
// @lc code=end

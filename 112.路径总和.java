import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        /*
         * if (root.left == null && root.right == null && targetSum == root.val) {
         * return true;
         * }
         * return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right,
         * targetSum - root.val);
         */
        Stack<Object> stack = new Stack<>();
        stack.push(root);
        stack.push(root.val);
        while (!stack.isEmpty()) {
            int val = (int) stack.pop();
            TreeNode node = (TreeNode) stack.pop();
            if (node.left == null && node.right == null && val == targetSum) {
                return true;
            }
            if (node.right != null) {
                stack.push(node.right);
                stack.push(val + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(val + node.left.val);
            }
        }
        return false;
    }
}
// @lc code=end

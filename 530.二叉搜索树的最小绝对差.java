/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
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
    public TreeNode pre;
    public int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}
// @lc code=end

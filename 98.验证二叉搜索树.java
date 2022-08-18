/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
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
    public TreeNode max;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左
        if (!isValidBST(root.left)) {
            return false;
        }
        // 中
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        // 右
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
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
    public int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        traversal(root);
        return root;
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        traversal(node.right); // 右
        sum += node.val;
        node.val = sum; // 中
        traversal(node.left); // 左
    }
}
// @lc code=end

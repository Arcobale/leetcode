import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=701 lang=java
 *
 * [701] 二叉搜索树中的插入操作
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        /*
         * if (root.val > val) {
         * root.left = insertIntoBST(root.left, val);
         * } else if (root.val < val) {
         * root.right = insertIntoBST(root.right, val);
         * }
         * return root;
         */
        TreeNode pre = root;
        TreeNode cur = root;
        while (cur != null) {
            pre = cur;
            if (cur.val > val) {
                cur = cur.left;
            } else if (cur.val < val) {
                cur = cur.right;
            }
        }
        if (pre.val > val) {
            pre.left = new TreeNode(val);
        } else if (pre.val < val) {
            pre.right = new TreeNode(val);
        }
        return root;
    }
}
// @lc code=end

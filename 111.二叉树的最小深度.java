/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();
            depth++;

            while (len-- > 0) {
                TreeNode temp = que.poll();
                // 如果当前节点的左右孩子都为空，直接返回最小深度
                if (temp.left == null && temp.right == null) {
                    return depth;
                }

                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }
        }

        return depth;
    }
}
// @lc code=end

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=617 lang=java
 *
 * [617] 合并二叉树
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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        /*
         * root1.val += root2.val;
         * root1.left = mergeTrees(root1.left, root2.left);
         * root1.right = mergeTrees(root1.right, root2.right);
         * return root1;
         */
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root1);
        que.offer(root2);
        while (!que.isEmpty()) {
            TreeNode node1 = que.poll();
            TreeNode node2 = que.poll();
            node1.val += node2.val;
            if (node1.left != null && node2.left != null) {
                que.offer(node1.left);
                que.offer(node2.left);
            }
            if (node1.right != null && node2.right != null) {
                que.offer(node1.right);
                que.offer(node2.right);
            }
            if (node1.left == null && node2.left != null) {
                node1.left = node2.left;
            }
            if (node1.right == null && node2.right != null) {
                node1.right = node2.right;
            }
        }
        return root1;
    }
}
// @lc code=end

import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=100 lang=java
 *
 * [100] 相同的树
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(p);
        que.offer(q);
        while (!que.isEmpty()) {
            TreeNode one = que.poll();
            TreeNode two = que.poll();
            if (one == null && two == null) {
                continue;
            } else if (one == null || two == null || one.val != two.val) {
                return false;
            }

            que.offer(one.left);
            que.offer(two.left);
            que.offer(one.right);
            que.offer(two.right);
        }
        return true;
    }
}
// @lc code=end

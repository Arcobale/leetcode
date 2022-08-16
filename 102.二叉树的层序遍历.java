import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // order(root, 0);
        if (root == null) {
            return result;
        }
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int len = que.size();
            while (len-- > 0) {
                TreeNode temp = que.poll();
                item.add(temp.val);
                if (temp.left != null) {
                    que.offer(temp.left);
                }
                if (temp.right != null) {
                    que.offer(temp.right);
                }
            }
            result.add(item);
        }

        return result;
    }

    /*
     * private void order(TreeNode cur, int depth) {
     * if (cur == null) {
     * return;
     * }
     * if (result.size() == depth) {
     * List<Integer> item = new ArrayList<>();
     * result.add(item);
     * }
     * result.get(depth).add(cur.val);
     * order(cur.left, depth + 1);
     * order(cur.right, depth + 1);
     * }
     */
}
// @lc code=end

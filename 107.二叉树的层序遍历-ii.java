/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(result);
        return result;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        /*
         * Stack<Object> stack = new Stack<>();
         * stack.push(root);
         * stack.push(root.val + "");
         * 
         * while (!stack.isEmpty()) {
         * String path = (String) stack.pop();
         * TreeNode node = (TreeNode) stack.pop();
         * if (node.left == null && node.right == null) {
         * result.add(path);
         * }
         * if (node.right != null) {
         * stack.push(node.right);
         * stack.push(path + "->" + node.right.val);
         * }
         * if (node.left != null) {
         * stack.push(node.left);
         * stack.push(path + "->" + node.left.val);
         * }
         * }
         */
        List<Integer> path = new ArrayList<>();
        searchPath(root, path, result);
        return result;
    }

    private void searchPath(TreeNode node, List<Integer> path, List<String> result) {
        path.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sb.append(path.get(i)).append("->");
            }
            sb.append(path.get(path.size() - 1));
            result.add(sb.toString());
            return;
        }

        if (node.left != null) {
            searchPath(node.left, path, result);
            path.remove(path.size() - 1); // 回溯
        }
        if (node.right != null) {
            searchPath(node.right, path, result);
            path.remove(path.size() - 1); // 回溯
        }
    }
}
// @lc code=end

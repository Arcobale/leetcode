import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        traversal(root, result, path, targetSum);
        return result;
    }

    private void traversal(TreeNode node, List<List<Integer>> result, List<Integer> path, int targetSum) {
        if (node == null) {
            return;
        }
        path.add(node.val);

        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (node.left != null) {
            traversal(node.left, result, path, targetSum - node.val);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            traversal(node.right, result, path, targetSum - node.val);
            path.remove(path.size() - 1);
        }
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
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
    public Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        traversal(root);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        PriorityQueue<Map.Entry<Integer, Integer>> que = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        for (Map.Entry<Integer, Integer> entry : entries) {
            que.offer(entry);
        }

        int max = que.peek().getValue();
        int len = que.size();
        result.add(que.poll().getKey());

        for (int i = 1; i < len; i++) {
            if (que.peek().getValue() == max) {
                result.add(que.poll().getKey());
            } else {
                break;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        traversal(node.left);
        traversal(node.right);
    }
}
// @lc code=end

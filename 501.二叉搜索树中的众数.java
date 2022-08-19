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
    List<Integer> result = new ArrayList<>();
    int maxCount = 0;
    int count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        traversal(root);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        traversal(cur.left);

        if (pre == null) {
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        } else {
            count = 1;
        }
        pre = cur;

        if (count == maxCount) {
            result.add(cur.val);
        } else if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(cur.val);
        }

        traversal(cur.right);
    }
}
// @lc code=end

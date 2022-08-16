import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                stack.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right != null) {
                    stack.push(node.right); // 添加右节点（空节点不入栈）
                }
                stack.push(node); // 添加中节点
                stack.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.left != null) {
                    stack.push(node.left); // 添加左节点（空节点不入栈）
                }
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                stack.pop(); // 将空节点弹出
                node = stack.pop(); // 重新取出栈中元素
                result.add(node.val); // 加入到结果集
            }
        }

        return result;
    }
}
// @lc code=end

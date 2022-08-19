import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
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
    public TreeNode deleteNode(TreeNode root, int key) {
        // 第一种情况：没找到删除的节点，遍历到空节点直接返回了
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null && root.right == null) { // 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
                return null;
            } else if (root.left == null && root.right != null) { // 第三种情况：其左孩子为空，右孩子不为空，删除节点，右孩子补位 ，返回右孩子为根节点
                return root.right;
            } else if (root.left != null && root.right == null) { // 第四种情况：其右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
                return root.left;
            }
            // 第五种情况：左右孩子节点都不为空，则将删除节点的左子树放到删除节点的右子树的最左面节点的左孩子的位置
            // 并返回删除节点右孩子为新的根节点。
            TreeNode temp = root.right;
            while (temp.left != null) {
                temp = temp.left;
            }
            temp.left = root.left;
            return root.right;
        }

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }
}
// @lc code=end

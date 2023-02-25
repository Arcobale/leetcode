/*
 * @lc app=leetcode.cn id=968 lang=javascript
 *
 * [968] 监控二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var minCameraCover = function(root) {
    let result = 0;

    function traverse(root) {
        if (!root) return 2; // 空节点表示有覆盖
        if (!root.left && !root.right) return 0; //叶子节点表示无覆盖

        let left = traverse(root.left);
        let right = traverse(root.right);

        if (left == 2 && right == 2) {
            return 0;
        } else if (left == 0 || right == 0) {
            result++;
            return 1;
        } else if (left == 1 || right == 1) {
            return 2;
        }

    }

    if (traverse(root) == 0) {
        result++;
    }
    return result;
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=337 lang=javascript
 *
 * [337] 打家劫舍 III
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
var rob = function(root) {
    let resArr = postOrder(root);
    return Math.max(resArr[0], resArr[1]);
};
function postOrder(node) {
    if (node == null) return [0, 0];
    let left = postOrder(node.left);
    let right = postOrder(node.right);
    let val_no = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    let val_yes = node.val + left[0] + right[0];
    return [val_no, val_yes];
}
// @lc code=end


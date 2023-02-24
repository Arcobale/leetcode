/*
 * @lc app=leetcode.cn id=1005 lang=javascript
 *
 * [1005] K 次取反后最大化的数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var largestSumAfterKNegations = function(nums, k) {
    let sum = 0;
    nums.sort((a, b) => (Math.abs(b) - Math.abs(a))); // 绝对值从大到小
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] < 0 && k-- > 0) {
            nums[i] = -nums[i];
        }
        sum += nums[i];
    }
    if (k % 2 == 1) {
        sum -= 2*nums[nums.length - 1];
    }
    return sum;
};
// @lc code=end


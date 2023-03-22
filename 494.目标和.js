/*
 * @lc app=leetcode.cn id=494 lang=javascript
 *
 * [494] 目标和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var findTargetSumWays = function(nums, target) {
    let sum = nums.reduce((a, b) => (a + b), 0);
    if (Math.abs(target) > sum) return 0;
    if ((target + sum) % 2) return 0;
    let bagSize = (target + sum) / 2;
    let dp = new Array(bagSize + 1) .fill(0);
    dp[0] = 1


    for (let i = 0; i < nums.length; i++) {
        for (let j = bagSize; j >= nums[i]; j--) {
            dp[j] += dp[j - nums[i]];
        }
    }
    return dp[bagSize];
};
// @lc code=end


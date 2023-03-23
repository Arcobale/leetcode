/*
 * @lc app=leetcode.cn id=53 lang=javascript
 *
 * [53] 最大子数组和
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
/*     //贪心
    let result = -Infinity;
    let count = 0;  //保存连续和
    for (let num of nums) {
        count += num;
        if (count > result) result = count;
        if (count < 0) count = 0;
    }
    return result;
 */
    let dp = new Array(nums.length).fill(-Infinity);
    dp[0] = nums[0];
    let result = 0;
    for (let i = 1; i < nums.length; i++) {
        dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        result = Math.max(result, dp[i]);
    }
    return result;
};
// @lc code=end


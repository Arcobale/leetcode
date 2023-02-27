/*
 * @lc app=leetcode.cn id=416 lang=javascript
 *
 * [416] 分割等和子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {boolean}
 */
var canPartition = function(nums) {
    let n = nums.length;
    let sum = nums.reduce((a, b) => (a + b), 0);
    if (sum % 2) return false;
    
    let target = sum / 2;
    let dp = new Array(target + 1).fill(0);

    for (let i = 0; i < n; i++) {
        for (let j = target; j >= nums[i]; j--) {
            dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
        }
        console.log(dp);
    }
    return dp[target] == target;
};
// @lc code=end


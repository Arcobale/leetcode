/*
 * @lc app=leetcode.cn id=377 lang=javascript
 *
 * [377] 组合总和 Ⅳ
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var combinationSum4 = function(nums, target) {
    let dp = Array(target + 1).fill(0);
    dp[0] = 1;
    //如果求排列数就是外层for遍历背包，内层for循环遍历物品。
    for (let i = 1; i <= target; i++) {
        for (let j = 0; j < nums.length; j++) {
            if(i >= nums[j]) dp[i] += dp[i - nums[j]];
        }
    }
    return dp[target];
};
// @lc code=end


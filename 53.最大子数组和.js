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
    let result = -Infinity;
    let count = 0;  //保存连续和
    for (let num of nums) {
        count += num;
        if (count > result) result = count;
        if (count < 0) count = 0;
    }
    return result;
};
// @lc code=end


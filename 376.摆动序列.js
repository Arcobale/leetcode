/*
 * @lc app=leetcode.cn id=376 lang=javascript
 *
 * [376] 摆动序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var wiggleMaxLength = function(nums) {
    if (nums.length <= 1) return nums.length;
    let result = 1;
    let pre = 0;
    let cur = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        let cur = nums[i + 1] - nums[i];
        if (pre >= 0 && cur < 0 || pre <= 0 && cur > 0) {
            result++;
            pre = cur;
        }
    }

    return result;
};
// @lc code=end


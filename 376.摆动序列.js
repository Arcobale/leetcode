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
/*     // 贪心
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

    return result; */

    // 动态规划
    if (nums.length <= 1) return nums.length;
    let down = 1;  // 第i个值作为峰谷时的最大摆动序列长度 (i-1为峰顶)
    let up = 1;  // 第i个值作为峰顶时的最大摆动序列长度 (i-1为峰谷)
    for (let i = 1; i < nums.length; i++) {
        if (nums[i] > nums[i - 1]) {
            up = Math.max(down + 1, up);
        }
        if (nums[i] < nums[i - 1]) {
            down = Math.max(up + 1, down);
        }
    }
    return Math.max(down, up);
};
// @lc code=end


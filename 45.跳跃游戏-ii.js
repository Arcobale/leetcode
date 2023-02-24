/*
 * @lc app=leetcode.cn id=45 lang=javascript
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let step = 0;
    let nextCover = 0;
    let curCover = 0;
    for (let i = 0; i < nums.length - 1; i++) {
        nextCover = Math.max(i + nums[i], nextCover);
        if (i == curCover) {
            curCover = nextCover;
            step++;
        }
    }
    return step;
};
// @lc code=end


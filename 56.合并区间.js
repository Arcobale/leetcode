/*
 * @lc app=leetcode.cn id=56 lang=javascript
 *
 * [56] 合并区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    let result = [];
    intervals.sort((a, b) => (a[0] - b[0]));   // 左边界排序

    let pre = intervals[0];
    for (let i = 1; i < intervals.length; i++) {
        let cur = intervals[i];
        if (pre[1] < cur[0]) {
            result.push(pre);
            pre = cur;
        } else {
            pre[1] = Math.max(pre[1], cur[1]);
        }
    }
    result.push(pre);
    return result;
};
// @lc code=end


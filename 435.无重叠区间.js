/*
 * @lc app=leetcode.cn id=435 lang=javascript
 *
 * [435] 无重叠区间
 */

// @lc code=start
/**
 * @param {number[][]} intervals
 * @return {number}
 */
var eraseOverlapIntervals = function(intervals) {
    let count = 1;
    intervals.sort((a, b) => (a[1] - b[1]));  // 右边界排序

    let right = intervals[0][1];
    for (let interval of intervals) {
        if (interval[0] >= right) {
            count++;
            right = interval[1];
        }
    }

    return intervals.length - count;
};
// @lc code=end


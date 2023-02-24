/*
 * @lc app=leetcode.cn id=452 lang=javascript
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var findMinArrowShots = function(points) {
    let result = 1;
    points.sort((a, b) => a[0] - b[0]);

    for (let i = 1; i < points.length; i++) {
        if (points[i][0] <= points[i - 1][1]) {
            points[i][1] = Math.min(points[i][1], points[i - 1][1]);
        } else {
            result++;
        }
    }

    return result;
};
// @lc code=end


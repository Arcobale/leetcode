/*
 * @lc app=leetcode.cn id=406 lang=javascript
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
/**
 * @param {number[][]} people
 * @return {number[][]}
 */
var reconstructQueue = function(people) {
    let result = [];
    people.sort((a, b) => {
        if (a[0] != b[0]) {
            return b[0] - a[0];
        } else {
            return a[1] - b[1];
        }
    })

    for (let p of people) {
        result.splice(p[1], 0, p);
    }
    return result;
};
// @lc code=end


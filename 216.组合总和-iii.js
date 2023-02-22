/*
 * @lc app=leetcode.cn id=216 lang=javascript
 *
 * [216] 组合总和 III
 */

// @lc code=start
/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
let result = [];
let path = [];
var combinationSum3 = function(k, n) {
    result = [];
    backtracking(k, n, 0, 1);
    return result;
};
function backtracking(k, n, sum, startIndex) {
    if (sum > n) {
        return;
    }
    if (path.length == k && sum == n) {
        result.push([...path]);
        return;
    }
    for (let i = startIndex; i <= 9 - (k - path.length) + 1; i++) {
        path.push(i);
        sum += i;
        backtracking(k, n, sum, i + 1);
        path.pop();
        sum -= i;
    }
}
// @lc code=end


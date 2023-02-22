/*
 * @lc app=leetcode.cn id=40 lang=javascript
 *
 * [40] 组合总和 II
 */

// @lc code=start
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
let result = [];
let path = [];
var combinationSum2 = function(candidates, target) {
    result = [];
    candidates.sort((a, b) => (a - b));
    backtracking(candidates, target, 0, 0);
    return result;
};
function backtracking(candidates, target, sum, startIndex) {
    if (target < sum) return;
    if (target == sum) {
        result.push([...path]);
        return;
    }
    for (let i = startIndex; i < candidates.length; i++) {
        let number = candidates[i];
        if (i > startIndex && number == candidates[i - 1]) continue;
        path.push(number);
        sum += number;
        backtracking(candidates, target, sum, i + 1);
        path.pop();
        sum -= number;
    }
}
// @lc code=end


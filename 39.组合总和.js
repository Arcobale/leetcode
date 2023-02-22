/*
 * @lc app=leetcode.cn id=39 lang=javascript
 *
 * [39] 组合总和
 */

// @lc code=start
/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
let result = [];
let path = [];
var combinationSum = function(candidates, target) {
    result = [];
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
        path.push(number);
        sum += number;
        backtracking(candidates, target, sum, i);
        path.pop();
        sum -= number;
    }
}
// @lc code=end


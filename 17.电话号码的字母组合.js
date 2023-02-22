/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
let result = [];
let path = [];
const alpha = ["", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];

var letterCombinations = function(digits) {
    result = [];
    let k = digits.length;
    if (k == 0) return [];
    if (k == 1) return alpha[digits].split("");
    backtracking(digits, k, 0);
    return result;
};
function backtracking(digits, k, index) {
    if (path.length == k) {
        result.push(path.join(""));
        return;
    }
    for (let letter of alpha[digits[index]]) {
        path.push(letter);
        backtracking(digits, k, index + 1);
        path.pop();
    }

}
// @lc code=end


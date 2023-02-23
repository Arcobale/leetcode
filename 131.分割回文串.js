/*
 * @lc app=leetcode.cn id=131 lang=javascript
 *
 * [131] 分割回文串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[][]}
 */
var partition = function(s) {
    let result = [];
    let path = [];
    
    function backtracking(startIndex) {
        if (startIndex >= s.length) {
            result.push([...path]);
            return;
        }
        for (let i = startIndex; i < s.length; i++) {
            let substr = s.slice(startIndex, i + 1);
            if (!isPalindrome(substr)) return;
            path.push(substr);
            backtracking(i + 1);
            path.pop();
        }
    }

    backtracking(0);
    return result;
};
function isPalindrome(str) {
    for (let i = 0, j = str.length - 1; i < j; i++, j--) {
        if (str[i] != str[j]) return false;
    }
    return true;
}
// @lc code=end


/*
 * @lc app=leetcode.cn id=647 lang=javascript
 *
 * [647] 回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var countSubstrings = function(s) {
/*     //动态规划 空间复杂度n方
    let dp = new Array(s.length).fill(false).map(() => new Array(s.length).fill(false));
    let result = 0;
    for (let i = s.length - 1; i >= 0; i--) {
        for (let j = i; j < s.length; j++) {
            if (s[i] == s[j]) {
                if (j - i <= 1 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    result++;
                }
            }
        }
    }
    return result;
 */
    //双指针 空间复杂度1
    let result = 0;
    for (let i = 0; i < s.length; i++) {
        result += extend(s, i, i, s.length);
        result += extend(s, i, i + 1, s.length);
    }
    return result;
};
function extend(s, i, j, n) {
    let count = 0;
    while (i >= 0 && j < n && s[i] == s[j]) {
        i--;
        j++;
        count++;
    }
    return count;
}
// @lc code=end


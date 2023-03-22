/*
 * @lc app=leetcode.cn id=474 lang=javascript
 *
 * [474] 一和零
 */

// @lc code=start
/**
 * @param {string[]} strs
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var findMaxForm = function(strs, m, n) {
    let dp = Array(m + 1).fill(0).map(item => Array(n + 1).fill(0));
    let zeroNum;
    let oneNum;
    for (let str of strs) {
        zeroNum = 0;
        oneNum = 0;
        for (let s of str) {
            if (s == '1') oneNum++;
            else zeroNum++;
        }
        for (let i = m; i >= zeroNum; i--) {
            for (let j = n; j >= oneNum; j--) {
                dp[i][j] = Math.max(dp[i - zeroNum][j - oneNum] + 1, dp[i][j]);
            }
        }
    }
    return dp[m][n];
};
// @lc code=end


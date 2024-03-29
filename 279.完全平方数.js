/*
 * @lc app=leetcode.cn id=279 lang=javascript
 *
 * [279] 完全平方数
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    let dp = new Array(n + 1).fill(Infinity);
    dp[0] = 0;
    for (let i = 1; i * i <= n; i++) {
        for (let j = i * i; j <= n; j++) {
            dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
        }
    }
    return dp[n];
};
// @lc code=end


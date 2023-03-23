/*
 * @lc app=leetcode.cn id=188 lang=javascript
 *
 * [188] 买卖股票的最佳时机 IV
 */

// @lc code=start
/**
 * @param {number} k
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(k, prices) {
    let len = 2 * k + 1;
    let dp = new Array(prices.length).fill(0).map(item => new Array(len).fill(0));
    for (let j = 1; j < len; j += 2) {
        dp[0][j] = -prices[0];
    }
    for (let i = 1; i < prices.length; i++) {
        for (let j = 1; j < len; j++) {
            if (j % 2) dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
            else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
        }
    }
    return dp[prices.length - 1][len - 1];
};
// @lc code=end


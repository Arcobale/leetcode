/*
 * @lc app=leetcode.cn id=122 lang=javascript
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
/*  //贪心
    let result = 0;
    for (let i = 1; i < prices.length; i++) {
        if (prices[i] - prices[i - 1] > 0) {
            result += prices[i] - prices[i - 1];  // 只收集正利润
        }
    }
    return result;
 */
    let dp = new Array(prices.length).fill([0, 0]);
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    for (let i = 1; i < prices.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
    }
    return dp[prices.length - 1][1];
};
// @lc code=end


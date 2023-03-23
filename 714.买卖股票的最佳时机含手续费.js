/*
 * @lc app=leetcode.cn id=714 lang=javascript
 *
 * [714] 买卖股票的最佳时机含手续费
 */

// @lc code=start
/**
 * @param {number[]} prices
 * @param {number} fee
 * @return {number}
 */
var maxProfit = function(prices, fee) {
/*     //贪心
    let result = 0;
    let minPrice = prices[0];

    for (let i = 1; i < prices.length; i++) {
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }
        if (prices[i] - minPrice - fee > 0) {
            result += prices[i] - minPrice - fee;
            minPrice = prices[i] - fee;   // important
        }
    }
    return result;
 */
    let dp = new Array(prices.length).fill(0).map(() => new Array(2).fill(0));
    dp[0][0] = -prices[0];
    dp[0][1] = 0;
    for (let i = 1; i < prices.length; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
        dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
    }
    return dp[prices.length - 1][1];
};
// @lc code=end


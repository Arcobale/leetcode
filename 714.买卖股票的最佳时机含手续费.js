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
};
// @lc code=end


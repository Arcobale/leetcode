/*
 * @lc app=leetcode.cn id=135 lang=javascript
 *
 * [135] 分发糖果
 */

// @lc code=start
/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function(ratings) {
    let candy = new Array(ratings.length).fill(1);
    // 从左向右遍历
    for (let i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i - 1]) {
            candy[i] = candy[i - 1] + 1;
        }
    }
    // 从右向左遍历
    for (let i = ratings.length - 2; i >= 0; i--) {
        if (ratings[i] > ratings[i + 1]) {
            candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
        }
    }
    
    let result = candy.reduce((sum, num) => sum + num, 0);

    return result;
};
// @lc code=end


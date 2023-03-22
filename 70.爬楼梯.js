/*
 * @lc app=leetcode.cn id=70 lang=javascript
 *
 * [70] 爬楼梯
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
    let dp = new Array(n + 1).fill(0);
/*  //斐波那契式
    dp[1] = 1;
    dp[2] = 2;
    for (let i = 3; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
     */
    //背包问题
    dp[0] = 1;
    let step = [1, 2];
    for (let i = 1; i <= n; i++){
        for (let j = 0; j < step.length; j++) {
            if(i >= step[j]) dp[i] += dp[i - step[j]];
        }
    }
    return dp[n];
};
// @lc code=end


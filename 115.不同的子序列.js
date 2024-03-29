/*
 * @lc app=leetcode.cn id=115 lang=javascript
 *
 * [115] 不同的子序列
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} t
 * @return {number}
 */
var numDistinct = function(s, t) {
    let dp = new Array(s.length + 1).fill(0).map(() => new Array(t.length + 1).fill(0));
    for (let i = 0; i <= s.length; i++) {
        dp[i][0] = 1;   //dp[i][0]：以i-1为结尾的s可以随便删除元素，出现空字符串的个数。
    }

    for (let i = 1; i <= s.length; i++) {
        for (let j = 1; j <= t.length; j++) {
            if (s[i - 1] == t[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[s.length][t.length];
};
// @lc code=end


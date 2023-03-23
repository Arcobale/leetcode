/*
 * @lc app=leetcode.cn id=72 lang=javascript
 *
 * [72] 编辑距离
 */

// @lc code=start
/**
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    let dp = new Array(word1.length + 1).fill(0).map(() => new Array(word2.length + 1).fill(0));
    //dp[i][0]：以下标i-1为结尾的字符串word1，和空字符串word2，最近编辑距离
    for (let i = 0; i <= word1.length; i++) {
        dp[i][0] = i;
    }
    //dp[0][j] ：以下标j-1为结尾的字符串word2，和空字符串word1，最近编辑距离
    for (let j = 0; j <= word2.length; j++) {
        dp[0][j] = j;
    }

    for (let i = 1; i <= word1.length; i++) {
        for (let j = 1; j <= word2.length; j++) {
            if (word1[i - 1] == word2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else {
                //考虑删（增）改操作
                dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
            }
        }
    }
    return dp[word1.length][word2.length];
};
// @lc code=end


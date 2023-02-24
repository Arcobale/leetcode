/*
 * @lc app=leetcode.cn id=455 lang=javascript
 *
 * [455] 分发饼干
 */

// @lc code=start
/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    let result = 0;
    g.sort((a, b) => (a - b));
    s.sort((a, b) => (a - b));

    let foodIndex = s.length - 1;
    for (let child = g.length - 1; child >= 0; child--) {
        if (foodIndex >= 0 && g[child] <= s[foodIndex]) {
            result++;
            foodIndex--;
        }
    }
    return result;
};
// @lc code=end


/*
 * @lc app=leetcode.cn id=3 lang=javascript
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    let result = 0;
    let start = 0;
    let map = {};

    for (let i = 0; i < s.length; i++) {
        if (s[i] in map) {
            start = Math.max(start, map[s[i]] + 1);
        }
        result = Math.max(result, i - start + 1);
        map[s[i]] = i;
    }

    return result;
};
// @lc code=end


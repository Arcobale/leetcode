/*
 * @lc app=leetcode.cn id=738 lang=javascript
 *
 * [738] 单调递增的数字
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number}
 */
var monotoneIncreasingDigits = function(n) {
    n = n.toString().split("").map((num) => (+num));
    let flag = n.length;
    for (let i = n.length - 1; i > 0; i--) {
        if (n[i - 1] > n[i]) {
            flag = i;
            n[i - 1]--;
            n[i] = 9;
        }
    }
    for (let i = flag; i < n.length; i++) {
        n[i] = 9;   // 取最大
    }
    return Number(n.join(""));
};
// @lc code=end


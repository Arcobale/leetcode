/*
 * @lc app=leetcode.cn id=93 lang=javascript
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string[]}
 */
var restoreIpAddresses = function(s) {
    let result = [];
    let path = [];

    function backtracking(startIndex) {
        if (path.length > 4) {
            return;
        }
        if (path.length == 4 && startIndex == s.length) {
            result.push(path.join("."));
            return;
        }
        for (let i = startIndex; i < s.length; i++) {
            let substr = s.slice(startIndex, i + 1);
            if (substr.length > 1 && substr[0] == 0) break;
            if (+substr > 255) break;
            path.push(substr);
            backtracking(i + 1);
            path.pop();
        }
    }
    backtracking(0);
    return result;
};
// @lc code=end


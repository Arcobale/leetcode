/*
 * @lc app=leetcode.cn id=491 lang=javascript
 *
 * [491] 递增子序列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var findSubsequences = function(nums) {
    let result = [];
    let path = [];

    function backtracking(startIndex) {
        if (path.length >= 2) {
            result.push([...path]);
        }
        let uset = [];
        for (let i = startIndex; i < nums.length; i++) {
            let number = nums[i];
            if (path.length > 0 && number < path[path.length - 1]) continue;
            if (uset[number + 100]) continue;
            uset[number + 100] = true;
            
            path.push(number);
            backtracking(i + 1);
            path.pop();
        }
    }

    backtracking(0);
    return result;
};
// @lc code=end


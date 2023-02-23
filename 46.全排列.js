/*
 * @lc app=leetcode.cn id=46 lang=javascript
 *
 * [46] 全排列
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    let result = [];
    let path = [];
    let used = [];

    function backtracking(used) {
        if (path.length == nums.length) {
            result.push([...path]);
            return;
        }
        for (let i = 0; i < nums.length; i++) {
            let number = nums[i];
            if (used[i]) continue;
            path.push(number);
            used[i] = true;
            backtracking(used);
            path.pop();
            used[i] = false;
        }
    }

    backtracking(used);
    return result;
};
// @lc code=end


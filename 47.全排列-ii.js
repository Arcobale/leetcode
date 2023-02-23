/*
 * @lc app=leetcode.cn id=47 lang=javascript
 *
 * [47] 全排列 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    let result = [];
    let path = [];
    let used = [];
    nums.sort((a, b) => (a - b));

    function backtracking(used) {
        if (path.length == nums.length) {
            result.push([...path]);
            return;
        }
        for (let i = 0; i < nums.length; i++) {
            let number = nums[i];
            if (used[i]) continue;
            if (i > 0 && number == nums[i - 1] && used[i - 1] == false) continue;
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


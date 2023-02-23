/*
 * @lc app=leetcode.cn id=90 lang=javascript
 *
 * [90] 子集 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    let result = [];
    let path = [];
    nums.sort((a, b) => (a - b));

    function backtracking(startIndex) {
        result.push([...path]);

        for (let i = startIndex; i < nums.length; i++) {
            let number = nums[i];
            if (i > startIndex && number == nums[i - 1]) continue;
            path.push(number);
            backtracking(i + 1);
            path.pop();
        }
    }

    backtracking(0);
    return result;
};
// @lc code=end


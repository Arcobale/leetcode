/*
 * @lc app=leetcode.cn id=134 lang=javascript
 *
 * [134] 加油站
 */

// @lc code=start
/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    let curRest = 0;
    let totalRest = 0;
    let start = 0;
    for (let i = 0; i < gas.length; i++) {
        curRest += gas[i] - cost[i];
        totalRest += gas[i] - cost[i];
        if (curRest < 0) {
            curRest = 0;
            start = i + 1;
        }
    }
    if (totalRest < 0) return -1;
    return start;
};
// @lc code=end


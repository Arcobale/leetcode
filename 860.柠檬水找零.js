/*
 * @lc app=leetcode.cn id=860 lang=javascript
 *
 * [860] 柠檬水找零
 */

// @lc code=start
/**
 * @param {number[]} bills
 * @return {boolean}
 */
var lemonadeChange = function(bills) {
    let fiveCount = 0;
    let tenCount = 0;

    for (let i = 0; i < bills.length; i++) {
        if (bills[i] == 5) {
            fiveCount++;
        } else if (bills[i] == 10) {
            if (fiveCount > 0) {
                tenCount++;
                fiveCount--;
            } else {
                return false;
            }
        } else if (bills[i] == 20) {
            if (tenCount > 0 && fiveCount > 0) {
                tenCount--;
                fiveCount--;
            } else if (tenCount <= 0 && fiveCount >= 3) {
                fiveCount -=3;
            } else {
                return false;
            }
        }
    }
    return true;
};
// @lc code=end


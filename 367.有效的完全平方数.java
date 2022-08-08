/*
 * @lc app=leetcode.cn id=367 lang=java
 *
 * [367] 有效的完全平方数
 */

// @lc code=start
class Solution {
    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = (left + right) / 2;
            long temp = (long) mid * mid;
            if (temp > num) {
                right = mid - 1;
            } else if (temp < num) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        } else if (x < 4) {
            return 1;
        }
        int left = 1;
        int right = x / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            long temp = (long) mid * mid;
            if (temp > x) {
                right = mid;
            } else if (temp < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return (long) left * left > x ? left - 1 : left;
    }
}
// @lc code=end

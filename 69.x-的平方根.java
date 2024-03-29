/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根 
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            long temp = (long) mid * mid;
            if (temp > x) {
                right = mid - 1;
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

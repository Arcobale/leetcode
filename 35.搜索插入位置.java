/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
// @lc code=end

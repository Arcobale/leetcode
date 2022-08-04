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

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2 + 1;
            if (nums[mid] < target) {
                left = mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return nums[left] < target ? left + 1 : left;
    }
}
// @lc code=end

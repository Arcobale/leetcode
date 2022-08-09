/*
 * @lc app=leetcode.cn id=977 lang=java
 *
 * [977] 有序数组的平方
 */

// @lc code=start
class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[nums.length];
        int i = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[i--] = nums[left] * nums[left];
                left++;
            } else {
                result[i--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
// @lc code=end

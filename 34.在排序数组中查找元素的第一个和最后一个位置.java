/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length <= 0) {
            return new int[] { -1, -1 };
        }
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[] { -1, -1 };
        }
        if (rightBorder - leftBorder > 1) {
            return new int[] { leftBorder + 1, rightBorder - 1 };
        }
        return new int[] { -1, -1 };
    }

    private int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while (left <= right) { // 当left==right，区间[left, right]依然有效
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else { // 当nums[middle] == target的时候，更新left，这样才能得到target的右边界
                left = mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    private int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) { // 寻找左边界，就要在nums[middle] == target的时候更新right
                right = mid - 1;
                leftBorder = right;
            } else {
                left = mid + 1;
            }
        }
        return leftBorder;
    }
}
// @lc code=end

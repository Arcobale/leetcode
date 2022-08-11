import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

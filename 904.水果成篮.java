/*
 * @lc app=leetcode.cn id=904 lang=java
 *
 * [904] 水果成篮
 */

// @lc code=start
class Solution {
    public int totalFruit(int[] fruits) {
        int firstType = -1, secondType = -1;
        int type_sum = 0;
        int result = Integer.MIN_VALUE;
        for (int left = 0, right = 0; right < fruits.length; right++) {
            if (secondType != fruits[right] && firstType != fruits[right]) {
                type_sum++;
                firstType = secondType;
                secondType = fruits[right];
            }
            if (type_sum <= 2) {
                result = Math.max(result, right - left + 1);
            } else {
                left = right - 1;
                firstType = fruits[left--];
                while (firstType == fruits[left]) {
                    left--;
                }
                left++;
                type_sum--;
            }
        }
        return result;
    }
}
// @lc code=end

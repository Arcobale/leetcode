import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }
}
// @lc code=end

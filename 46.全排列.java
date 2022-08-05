import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtracking(new ArrayList<Integer>(), nums, visited, result);
        return result;
    }

    private void backtracking(ArrayList<Integer> cur, int[] nums, boolean[] visited, List<List<Integer>> result) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.add(nums[i]);
                backtracking(cur, nums, visited, result);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
// @lc code=end

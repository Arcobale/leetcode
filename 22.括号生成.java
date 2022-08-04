/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        dfs("", n, n, result);
        return result;
    }

    private void dfs(String cur, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }
        if (left > right) {
            return; // 剪枝
        }
        if (left > 0) {
            dfs(cur + '(', left - 1, right, result);
        }
        if (right > 0) {
            dfs(cur + ')', left, right - 1, result);
        }
    }
}
// @lc code=end

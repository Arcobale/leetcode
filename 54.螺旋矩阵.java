import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0; // 每次循环起点（start, start）
        int loop = 0; // 循环次数
        int count = 1; // 填充数字
        int i, j;

        while (loop++ < Math.min(m / 2, n / 2)) { // 判断边界后，loop从1开始
            // 上侧从左到右
            for (j = start; j < n - loop; j++) {
                result.add(matrix[start][j]);
            }
            // 右侧从上到下
            for (i = start; i < m - loop; i++) {
                result.add(matrix[i][j]);
            }
            // 下侧从右到左
            for (; j >= loop; j--) {
                result.add(matrix[i][j]);
            }
            // 左侧从下到上
            for (; i >= loop; i--) {
                result.add(matrix[i][j]);
            }
            start++;
        }
        if (result.size() == m * n) {
            return result;
        }
        if (m >= n) {
            for (i = start; i <= m - loop; i++) {
                result.add(matrix[i][start]);
            }
        } else if (m < n) {
            for (j = start; j <= n - loop; j++) {
                result.add(matrix[start][j]);
            }
        }
        return result;
    }
}
// @lc code=end

/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int start = 0; // 每次循环起点（start, start）
        int loop = 0; // 循环次数
        int count = 1; // 填充数字
        int i, j;

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 上侧从左到右
            for (j = start; j < n - loop; j++) {
                result[start][j] = count++;
            }
            // 右侧从上到下
            for (i = start; i < n - loop; i++) {
                result[i][j] = count++;
            }
            // 下侧从右到左
            for (; j >= loop; j--) {
                result[i][j] = count++;
            }
            // 左侧从下到上
            for (; i >= loop; i--) {
                result[i][j] = count++;
            }

            start++;
        }
        if (n % 2 == 1) {
            result[start][start] = count;
        }
        return result;
    }
}
// @lc code=end

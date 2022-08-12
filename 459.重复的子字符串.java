/*
 * @lc app=leetcode.cn id=459 lang=java
 *
 * [459] 重复的子字符串
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n == 0) {
            return false;
        }
        int[] next = new int[n];
        getNext(next, s);

        int m = next[n - 1];
        // 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度。
        // 如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        if (m > 0 && n % (n - m) == 0) {
            return true;
        }
        return false;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
// @lc code=end

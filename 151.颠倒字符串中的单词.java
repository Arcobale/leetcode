/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 颠倒字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        char[] initialArr = s.toCharArray();
        char[] newArr = new char[initialArr.length + 1];
        int k = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            while (i >= 0 && initialArr[i] == ' ') {
                i--;
            }
            int end = i;
            while (i >= 0 && initialArr[i] != ' ') {
                i--;
            }
            for (int start = i + 1; start <= end; start++) {
                newArr[k++] = initialArr[start];
                if (start == end) {
                    newArr[k++] = ' ';
                }
            }
        }
        if (k == 0) {
            return "";
        } else {
            return new String(newArr, 0, k - 1);
        }
    }
}
// @lc code=end

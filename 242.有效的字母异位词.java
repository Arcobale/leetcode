/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (char c1 : s.toCharArray()) {
            alphabet[c1 - 'a']++;
        }
        for (char c2 : t.toCharArray()) {
            alphabet[c2 - 'a']--;
        }
        for (int i : alphabet) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

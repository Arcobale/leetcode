/*
 * @lc app=leetcode.cn id=383 lang=java
 *
 * [383] 赎金信
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c1 : magazine.toCharArray()) {
            alphabet[c1 - 'a']++;
        }
        for (char c2 : ransomNote.toCharArray()) {
            alphabet[c2 - 'a']--;
        }
        for (int i : alphabet) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

import java.util.List;

/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length(), lenP = p.length();
        if (lenS < lenP) {
            return new ArrayList<>();
        }

        int[] tableS = new int[26];
        int[] tableP = new int[26];
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < lenP; i++) {
            tableS[s.charAt(i) - 'a']++;
            tableP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(tableS, tableP)) {
            result.add(0);
        }
        for (int i = 0; i < lenS - lenP; i++) {
            tableS[s.charAt(i) - 'a']--;
            tableS[s.charAt(i + lenP) - 'a']++;
            if (Arrays.equals(tableS, tableP)) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
// @lc code=end

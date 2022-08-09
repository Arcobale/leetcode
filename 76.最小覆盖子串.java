import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] have = new int[128];

        // 目标字符串指定字符的出现次数记录
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        // 分别为最小长度(初始值为一定不可达到的长度)
        // 已有字符串中目标字符串指定字符的出现总频次以及最小覆盖子串在原字符串中的起始位置
        int min = Integer.MAX_VALUE, count = 0, start = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char r = s.charAt(right);
            // 说明该字符不被目标字符串需要，直接移动右指针
            if (need[r] == 0) {
                continue;
            }
            // 当且仅当已有字符串目标字符出现的次数小于目标字符串字符的出现次数时，count才会+1
            // 是为了后续能直接判断已有字符串是否已经包含了目标字符串的所有字符，不需要挨个比对字符出现的次数
            if (have[r] < need[r]) {
                count++;
            }
            have[r]++;

            // 当且仅当已有字符串已经包含了所有目标字符串的字符，且出现频次一定大于或等于指定频次
            while (count == t.length()) {
                char l = s.charAt(left);
                // 如果左边即将要去掉的字符不被目标字符串需要，那么不需要多余判断，直接可以移动左指针
                if (need[l] == 0) {
                    left++;
                    continue;
                }
                // 如果左边即将要去掉的字符被目标字符串需要，且出现的频次正好等于指定频次，那么如果去掉了这个字符，
                // 就不满足覆盖子串的条件，此时要破坏循环条件跳出循环，即控制目标字符串指定字符的出现总频次(count）-1
                if (have[l] == need[l]) {
                    if (min > right - left + 1) {
                        min = right - left + 1;
                        start = left;
                    }
                    count--;
                }
                have[l]--;
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
// @lc code=end

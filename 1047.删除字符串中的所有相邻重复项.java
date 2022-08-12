import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=1047 lang=java
 *
 * [1047] 删除字符串中的所有相邻重复项
 */

// @lc code=start
class Solution {
    public String removeDuplicates(String s) {
        // ArrayDeque会比LinkedList在除了删除元素这一点外会快一点
        Deque<Character> que = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (que.isEmpty() || c != que.peek()) {
                que.push(c);
            } else {
                que.pop();
            }
        }
        String res = "";
        while (!que.isEmpty()) {
            res = que.pop() + res;
        }
        return res;
    }
}
// @lc code=end

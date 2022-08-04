/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char temp = stack.pop();
                    if (c == ')') {
                        if (temp != '(') {
                            return false;
                        }
                    } else if (c == ']') {
                        if (temp != '[') {
                            return false;
                        }
                    } else if (c == '}') {
                        if (temp != '{') {
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

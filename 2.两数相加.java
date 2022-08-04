/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int next1 = 0;
        while (l1 != null || l2 != null || next1 != 0) {
            if (l1 != null) {
                next1 += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                next1 += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(next1 % 10);
            cur = cur.next;
            next1 /= 10;
        }
        return result.next;
    }
}
// @lc code=end

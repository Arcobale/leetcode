import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class MyDeque {
    Deque<Integer> deque = new LinkedList<>();

    void pop(int value) {
        if (!deque.isEmpty() && deque.peek() == value) {
            deque.poll();
        }
    }

    void add(int value) {
        while (!deque.isEmpty() && value > deque.peekLast()) {
            deque.pollLast();
        }
        deque.addLast(value);
    }

    int peek() {
        return deque.peek();
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int len = nums.length - k + 1;
        int[] res = new int[len];
        int num = 0;
        MyDeque myDeque = new MyDeque();
        for (int i = 0; i < k; i++) {
            myDeque.add(nums[i]);
        }
        res[num++] = myDeque.peek();
        for (int i = k; i < nums.length; i++) {
            myDeque.pop(nums[i - k]);
            myDeque.add(nums[i]);
            res[num++] = myDeque.peek();
        }

        return res;
    }
}
// @lc code=end

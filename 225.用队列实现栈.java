import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    Deque<Integer> que1;

    public MyStack() {
        que1 = new ArrayDeque<>();
    }

    public void push(int x) {
        que1.addLast(x);
    }

    public int pop() {
        int size = que1.size();
        size--;
        while (size-- > 0) {
            que1.addLast(que1.peekFirst());
            que1.pollFirst();
        }
        return que1.pollFirst();
    }

    public int top() {
        return que1.peekLast();
    }

    public boolean empty() {
        return que1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

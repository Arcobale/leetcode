/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int len = que.size();

            Node cur = que.poll();
            if (cur.left != null) {
                que.offer(cur.left);
            }
            if (cur.right != null) {
                que.offer(cur.right);
            }

            for (int i = 1; i < len; i++) {
                Node next = que.poll();
                if (next.left != null) {
                    que.offer(next.left);
                }
                if (next.right != null) {
                    que.offer(next.right);
                }

                cur.next = next;
                cur = cur.next;
            }
        }

        return root;
    }
}
// @lc code=end

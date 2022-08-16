import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N 叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> que = new LinkedList<Node>();
        que.offer(root);

        while (!que.isEmpty()) {
            List<Integer> item = new ArrayList<>();
            int len = que.size();

            for (int i = 0; i < len; i++) {
                Node temp = que.poll();
                item.add(temp.val);
                if (temp.children != null) {
                    List<Node> children = temp.children;
                    for (Node child : children) {
                        que.offer(child);
                    }
                }
            }
            result.add(item);
        }
        return result;
    }
}
// @lc code=end

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        // order(root, result);
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            if (node != null) {
                stack.pop();
                if (node.children != null) {
                    List<Node> children = node.children;
                    int len = children.size();
                    for (int i = len - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
                stack.push(node);
                stack.push(null);
            } else {
                stack.pop();
                node = stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }
    /*
     * private void order(Node root, List<Integer> result) {
     * if (root == null) {
     * return;
     * }
     * result.add(root.val);
     * if (root.children != null) {
     * for (Node child : root.children) {
     * order(child, result);
     * }
     * }
     * }
     */
}
// @lc code=end

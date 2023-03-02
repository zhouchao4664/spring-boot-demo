package demo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2020/11/28 16:25
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/ 429. N 叉树的层序遍历
 */
public class levelOrder {
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
    }

    public List<List<Integer>> levelOrder(Node root) {
        preOrder(root, 0);
        return lists;
    }

    private List<List<Integer>> lists = new ArrayList<List<Integer>>();
    private void preOrder(Node root, int level) {
        if (root == null) return;
        if (lists.size() <= level)
            lists.add(new ArrayList<Integer>());
        lists.get(level).add(root.val);
        for (Node child : root.children)
            preOrder(child, level+1);
    }
}

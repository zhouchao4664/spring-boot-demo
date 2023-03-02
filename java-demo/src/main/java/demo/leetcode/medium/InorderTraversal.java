package demo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhouchao
 * @Date 2020/11/27 22:16
 * @Description https://leetcode-cn.com/problems/binary-tree-inorder-traversal/ 94. 二叉树的中序遍历
 **/

public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
}

package demo.leecode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 16:01
 * @Description: https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/ 111. 二叉树的最小深度
 */
public class MinDepth {

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

    /*public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null) return 1 + minDepth(root.left);
        if (root.right != null) return 1 + minDepth(root.right);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }*/

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        list.add(nodeList);
        for (int i = 0; i <= list.size(); i++) {
            List<TreeNode> childList = new ArrayList<>();
            for (TreeNode treeNode : list.get(i)) {
                if (treeNode.left == null && treeNode.right == null) return ++i;
                if (treeNode.left != null) childList.add(treeNode.left);
                if (treeNode.right != null) childList.add(treeNode.right);
            }
            list.add(childList);
        }
        return 0;
    }


}

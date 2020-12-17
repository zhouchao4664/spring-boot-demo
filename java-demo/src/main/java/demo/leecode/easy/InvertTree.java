package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/12/2 21:52
 * @Description https://leetcode-cn.com/problems/invert-binary-tree/ 226. 翻转二叉树
 **/
public class InvertTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode leftNode = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(leftNode);

        return root;
    }

}

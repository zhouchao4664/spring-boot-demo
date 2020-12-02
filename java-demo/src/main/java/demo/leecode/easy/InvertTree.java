package demo.leecode.easy;

/**
 * @Author zhouchao
 * @Date 2020/12/2 21:52
 * @Description
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

package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Date 2020/12/3 16:57
 * @Description https://leetcode-cn.com/problems/validate-binary-search-tree/ 98. 验证二叉搜索树
 **/

public class IsValidBST {
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

    /*long cur = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (cur >= root.val) return false;
        cur = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }*/

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;

        if (minValue < root.val &&
                root.val < maxValue &&
                isBST(root.left, minValue, root.val) &&
                isBST(root.right, root.val, maxValue)) {
            return true;
        }
        return false;
    }
}
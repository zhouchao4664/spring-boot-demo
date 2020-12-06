package demo.leecode.easy;

/**
 * @Auther: zhouc
 * @Date: 2020/12/6 14:59
 * @Description: https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/ 104. 二叉树的最大深度
 */
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);

        int result = leftCount >= rightCount ? leftCount : rightCount;
        return ++result;
    }
}

package demo.leecode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: zhouc
 * @Date: 2020/12/9 23:32
 * @Description: https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description 515. 在每个树行中找最大值
 */
public class LargestValues {

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

    private List<Integer> result = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        if (root==null) return result;
        List<TreeNode> nextNodeList = new ArrayList<>();
        nextNodeList.add(root);
        selectLargestValues(nextNodeList);
        return result;
    }

    public void selectLargestValues(List<TreeNode> nodes) {
        if (nodes.isEmpty()) return;
        int maxValue = Integer.MIN_VALUE;
        List<TreeNode> nextNodeList = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.val>maxValue) maxValue = node.val;
            if (node.left!=null) nextNodeList.add(node.left);
            if (node.right!=null) nextNodeList.add(node.right);
        }
        result.add(maxValue);
        selectLargestValues(nextNodeList);
    }

}

package demo.leetcode.medium;

/**
 * @Author zhouchao
 * @Description 2. 两数相加 https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj
 * @Date 2023/3/2 11:33
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode temp = result;
        // 临时变量，进位用
        int i = 0;
        while (l1 != null || l2 != null || i == 1) {
            if (l1 == null) {
                l1 = new ListNode();
            }

            if (l2 == null) {
                l2 = new ListNode();
            }

            ListNode nextNode = new ListNode();

            int val = l1.val + l2.val + i;
            if (val > 9) {
                i = 1;
                val -= 10;
            } else {
                i = 0;
            }
            nextNode.val = val;
            temp.next = nextNode;
            temp = nextNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

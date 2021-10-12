package com.example.mvcdemo.test.b链表;

/**
 * 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 难度：中等
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 */

/**
 * 解法：使用双指针，快指针先走n步，然后快慢指针一起走，直到快指针.next为空，然后删除慢指针的next节点指向next.next
 * 问题在于当只有一个节点时，怎么删除，所以需要将快慢指针的初始值指向-1 ，-1.next = head;
 */
public class A_removeNthFromEnd {
    //Definition for singly-linked list.
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = new ListNode(-1,head);
        ListNode right = new ListNode(-1,head);
        ListNode res = left;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if(right == null){
            return head;
        }
        while(right!=null && right.next!=null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return res.next;
    }
}

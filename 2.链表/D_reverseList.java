package com.example.mvcdemo.test.b链表;

/**
 *给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 难度：easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 */

/**
 * 思路：
 * 1.递归，注意中断条件是head.next == null
 * 2.三指针
 */
public class D_reverseList {
    // Definition for singly-linked list.
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

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode res = reverseList(head.next);

        ListNode next = head.next;
        next.next = head;
        head.next = null;

        return res;
    }

    public ListNode reverseList2(ListNode head){
        if(head==null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode next = head;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}

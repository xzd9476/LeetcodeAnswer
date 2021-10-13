package com.example.mvcdemo.test.b链表;

/**
 * 给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 难度：中等
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 */

/**
 * 思路：可以用基础排序算法，由于需要nlogn时间复杂度。所以适用于链表的是归并算法。
 *
 * 先用快慢指针，将大链表拆成两个小链表，递归拆解，直到剩下n个长度为1的链表。
 * 相邻的两个有序链表合并， 递归合并，直到得到一个长度为n的大链表。
 */
public class B_sortList {
    //Definition for singly-linked list.
    public static class ListNode {
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

    public ListNode sortList(ListNode head) {
        return split(head);
    }

    //归并排序，先拆分成只有一个节点的链表，然后两个相邻的链表递归合并
    public ListNode split(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = head;
        ListNode preLeft = null;
        while(right!=null && right.next!=null){
            right = right.next.next;
            preLeft = left;
            left = left.next;
        }
        //将左链表的最后一个元素的next指向空，从而切断大链表，拆成两个小链表。
        preLeft.next = null;
        ListNode l = split(head);
        ListNode r = split(left);
        return merge(l,r);
    }

    //合并， 没啥好说的
    public ListNode merge(ListNode left,ListNode right){
        ListNode node = new ListNode(-1);
        ListNode preNode = node;
        while(left!=null && right!=null){
            if(left.val < right.val){
                node.next = left;
                node = node.next;
                left = left.next;
            }else{
                node.next = right;
                node = node.next;
                right = right.next;
            }
        }
        if(left!=null){
            node.next = left;
        }
        if(right!=null){
            node.next = right;
        }
        return preNode.next;
    }

}

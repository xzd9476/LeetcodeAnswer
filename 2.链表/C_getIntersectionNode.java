package com.example.mvcdemo.test.b链表;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 难度：easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 */

/**
 * 解法：双指针，A和B同时往后走，A走到最后一个了就指向headB,B走到最后一个了就指向headA.
 * 公式就是：lenA + lenB = lenB + lenA
 */
public class C_getIntersectionNode {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode goA = headA;
        ListNode goB = headB;
        while(goA!=goB){
            if(goA==null){
                goA = headB;
            }else{
                goA = goA.next;
            }

            if(goB == null){
                goB = headA;
            }else{
                goB = goB.next;
            }
        }
        return goA;
    }
}

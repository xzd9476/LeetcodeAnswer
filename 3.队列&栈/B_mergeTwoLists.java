package com.example.mvcdemo.test.c队列和栈;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 难度：easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 */

//思路：两种解法，解法1.迭代   解法2.递归
public class B_mergeTwoLists {
    //解法1：迭代，比较当前l1  l2的大小
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode nodePre = node;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                node.next = l1;
                l1 = l1.next;
            }else{
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if(l1!=null){
            node.next = l1;
        }
        if(l2!=null){
            node.next = l2;
        }
        return nodePre.next;
    }

    //解法2：递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode node = null;
        if(l1.val < l2.val){
            node = l1;
            node.next = mergeTwoLists(l1.next,l2);
        }else{
            node = l2;
            node.next = mergeTwoLists(l1,l2.next);
        }
        return node;
    }
}

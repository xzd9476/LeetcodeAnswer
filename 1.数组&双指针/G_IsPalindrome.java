package com.example.mvcdemo.test;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 难度：easy
 * 来源：力扣（LeetCode）T234
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 */
public class G_IsPalindrome {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 解法1：使用快慢指针，快指针一次走两步，当fast指针为空，说明慢指针已经走到中间，将慢指针后面的链表结点逆序，然后再从前遍历前半部分，从后遍历后半部分。
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //1.先通过快慢指针定位到中间的节点
        while(fast != null){
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
            slow = slow.next;
        }
        //2.中间节点以后的链表反转
        ListNode left = null;
        ListNode right = null;
        while(slow!=null){
            right = slow.next;
            slow.next = left;
            left = slow;
            slow = right;
        }
        //left==null，说明元素个数只有一个
        if(left== null){
            return true;
        }
        //3.tail往回遍历，head往后遍历
        while(left.next!=null){
            if(left.val != head.val){
                return false;
            }
            left = left.next;
            head = head.next;
        }

        return head.val == left.val;
    }


    /**
     * 解法2：递归，如果是回文那么正序遍历和逆序遍历应该是一样的
     */
    ListNode realHead;
    public boolean isPalindrome2(ListNode head) {
        realHead = head;
        return recursion(head);
    }

    public boolean recursion(ListNode head){
        if(head == null){
            return true;
        }
        boolean flag = recursion(head.next);
        if(head.val != realHead.val){
            return false;
        }
        realHead = realHead.next;
        return flag;
    }
}

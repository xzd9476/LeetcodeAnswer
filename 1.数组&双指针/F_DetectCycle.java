package com.example.mvcdemo.test;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 难度：medium
 * 来源：力扣（LeetCode）T142
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 */

/**
 * 思路：快慢指针，快指针一次走两步，慢指针一次走一步。
 * 当两个指针第一次相遇时，快指针走过X + Y + Z + Y ，慢指针走过X + Y
 * 通过 X + Y + Z + Y = 2(X + Y)，得X = Z
 * 然后让快指针指向head，一次走一步，慢指针一次走一步， 当再次相遇的地方就是环形链表入口。
 */
public class F_DetectCycle {
    //Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        fast = head;
        while(slow!=fast && slow!=null ){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

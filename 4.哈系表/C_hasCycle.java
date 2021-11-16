package com.example.mvcdemo.test.d哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * 难度：easy
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle/submissions/
 */

/**
 * 思路：1.哈希表存储每个节点；2.快慢指针
 */
public class C_hasCycle {
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

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        boolean res = false;
        while (head != null) {
            if (set.contains(head)) {
                res = true;
                break;
            }
            set.add(head);
            head = head.next;
        }
        return res;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            slow = slow.next;
            if (fast == slow && fast != null) {
                return true;
            }
        }
        return false;
    }
}

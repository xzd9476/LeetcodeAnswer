package com.example.mvcdemo.test.d哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 *
 * LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 */

//思路：使用双向链表+map，可以实现时间复杂度为1的LRU算法
public class D_LRUCache {
    class Node{
        Node pre,next;
        int val,key;
        Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    int capacity;
    Node head,tail;
    Map<Integer,Node> map;
    public D_LRUCache(int capacity) {
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            putHead(node);
            return node.val;
        }
        return -1;
    }

    public void remove(Node node){
        //node从原位置删除
        if(node !=null && node != head){
            node.pre.next = node.next;
            node.next.pre = node.pre;
            map.remove(node.key);
        }
    }
    public void putHead(Node node){
        //node放在首位
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
        map.put(node.key,node);
    }

    public void put(int key, int value) {
        if(capacity<=0){
            return;
        }
        Node node = new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
            putHead(node);
        }else{
            putHead(node);
            if(map.size() > capacity){
                remove(tail.pre);
            }
        }
    }
}


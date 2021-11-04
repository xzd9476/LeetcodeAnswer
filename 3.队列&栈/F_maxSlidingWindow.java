package com.example.mvcdemo.test.c队列和栈;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 *
 * 难度：hard
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 */

/**
 * 解法：使用大根堆。大根堆中存储数组（位置i,和值nums[i]）。然后遍历数组，入堆，拿到当前最大值。然后根据(当前位置-堆头位置)是否大于窗口值，来移除堆顶元素
 */
public class F_maxSlidingWindow {
    public static void main(String[] args) {
        F_maxSlidingWindow demo = new F_maxSlidingWindow();
        int[] a = new int[]{1,3,1,2,0,5};
        int[] res = demo.maxSlidingWindow(a,3);

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k>nums.length){
            return null;
        }
        int[] res = new int[nums.length-k+1];
        //构建大根堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1,int[] o2){
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        for(int i=0;i<k-1;i++){
            priorityQueue.add(new int[]{nums[i],i});
        }
        for(int i=k-1;i<nums.length;i++){
            priorityQueue.add(new int[]{nums[i],i});
            int[] temp = priorityQueue.peek();
            res[i-k+1] = temp[0];
            while(priorityQueue.size()>0 && priorityQueue.peek()[1] <= i-k+1){
                temp = priorityQueue.poll();
            }
        }
        return res;
    }
}


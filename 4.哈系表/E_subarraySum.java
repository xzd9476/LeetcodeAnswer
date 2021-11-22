package com.example.mvcdemo.test.d哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数k ，请你统计并返回该数组中和为k的连续子数组的个数。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 */

/**
 * 思路：使用前缀和+哈希表，计算出每个位置的前缀和，如果某两个前缀和之间相差k那么这两个数就是我们需要的连续子串，
 * 为了加快计算前缀和的差值，我们使用map来存储前缀和以及前缀和出现的次数
 */
public class E_subarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int current = pre - k;
            if (map.containsKey(current)) {
                count += map.get(current);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}

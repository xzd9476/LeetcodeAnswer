package com.example.mvcdemo.test.d哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * <p>
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * <p>
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * <p>
 * 难度：medium
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */

/**
 * 思路：枚举数组中的每个数 x，考虑以其为起点，不断尝试匹配 x+1, x+2, ⋯ 是否存在，假设最长匹配到了 x+y，那么以 x 为起点的最长连续序列即为 x, x+1, x+2, ⋯,x+y
 * 为了加速遍历，用set存储每个数，当x+n不存在时，说明连续终端，break并进行下一个数的遍历。
 */
public class B_longestConsecutive {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int flag = nums[i];
            int num = 1;
            if (!set.contains(flag - 1)) {
                for (int k = 1; k < nums.length; k++) {
                    if (set.contains(flag + k)) {
                        num++;
                    } else {
                        break;
                    }
                }
                res = Math.max(res, num);
            }
        }
        return res;

    }
}


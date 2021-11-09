package com.example.mvcdemo.test.c队列和栈;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 */

/**
 * 思路：使用滑动窗口，用left标记窗口最左边界，然后right往右边走，如果遇到重复的字符(用map来存储重复字符)，这left移动到重复字符处。
 */
public class I_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}

package com.example.mvcdemo.test;

/**
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 难度：hard
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 */

/**
 * 思路：使用滑动窗口思想。不断使right增大，直到窗口包含了t的所有元素。不断是left缩小，抛出不需要的字符，
 * 直到碰到一个必须包含的字符。记录此时字符串长度。
 * 需要解决的问题：如何判断窗口内包含了T的所有元素？ 可以用一个count来记录所需元素的数量，碰到了所需元素就count--
 */
public class E_minWindow {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        int[] needArr = new int[128];
        for(int i=0;i<t.length();i++){
            needArr[t.charAt(i)] += 1;
        }
        int left = 0;
        int right = 0;
        int count = t.length();
        int size = Integer.MAX_VALUE;
        String res = "";

        while(right < s.length()){
            char c = s.charAt(right);
            if(needArr[c] > 0){
                count--;
            }
            needArr[c] -= 1;
            if(count == 0){
                while(left < right && needArr[s.charAt(left)] < 0){
                    needArr[s.charAt(left)] += 1;
                    left++;
                }
                if(size > (right - left + 1)){
                    size = right - left + 1;
                    res = s.substring(left , right+1);
                }
                needArr[s.charAt(left)] += 1;
                left++;
                count++;
            }
            right ++;
        }
        return res;
    }
}

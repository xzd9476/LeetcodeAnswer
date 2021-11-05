package com.example.mvcdemo.test.c队列和栈;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 */

/**
 * 思路：递归法，将'[' 和 ']'作为递归的开始和终止条件。递归结束后将res*num倍数再return
 */
public class G_decodeString {
    public String decodeString(String s) {
        return recursionHelper(s);
    }

    int index = 0;
    public String recursionHelper(String s) {
        if (index >= s.length()) {
            return "";
        }
        int num = 0;
        String res = "";
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
                index++;
            }else if(c=='['){
                index++;
                String temp = recursionHelper(s);
                for(int i=0;i<num;i++){
                    res += temp;
                }
                num=0;
            }else if(c==']'){
                index++;
                return res;
            }else{
                index++;
                res += c;
            }
        }
        return res;
    }
}


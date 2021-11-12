package com.example.mvcdemo.test.d哈希表;

import java.util.*;

/**
 * 49.字母异位分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
 * <p>
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * 难度：medium
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 */

/**
 *思路：str转char[]，用Arrays对char[]排序，从而来判断是否出现异位字符串，再用Map<str,list<>>来存储结果
 */
public class A_groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String ,List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s,new ArrayList<>());
            list.add(strs[i]);
            if(!map.containsKey(s)){
                res.add(list);
            }
            map.put(s,list);
        }
        return res;
    }
}

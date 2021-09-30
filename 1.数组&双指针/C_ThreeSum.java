package com.example.mvcdemo.test;

import java.util.*;


/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 */

/**
 * 思路：排序+双指针。先对数组排序，然后定义left、right双指针，去找nums[i] + nums[left] + nums[right] == 0的三个数字。
 * 难点在于排除重复，所以在对i++，left++,right++的时候要判断是否与上一个值重复。
 */
public class C_ThreeSum {
    public static void main(String[] args) {
        C_ThreeSum c = new C_ThreeSum();
        int[] aa = {1,-1,-1,0};

        System.out.println(c.threeSum(aa));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length<3){
            return res;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length-i;j++){
                if(nums[j] < nums[j-1]){
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>=1&&nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                int target = 0-nums[left] - nums[right];
                if(target == nums[i]){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);
                    do{
                        left++;
                    }while(left<right && nums[left]==nums[left-1]);
                    do{
                        right--;
                    }while(left<right && nums[right]==nums[right+1]);
                    continue;
                }else if(target > nums[i]){
                    do{
                        left++;
                    }while(left<right && nums[left]==nums[left-1]);
                }else{
                    do{
                        right--;
                    }while(left<right && nums[right]==nums[right+1]);
                }
            }
        }
        return res;
    }
}

package com.example.mvcdemo.test;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 难度：easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */

/**
 * 解法：简单的，双指针，一个指针指向非零区域，另一个指针用来移动寻找非0值，找到了就和非零指针指向的值互换。
 */
public class I_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,1,2};
        I_MoveZeroes solution = new I_MoveZeroes();
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int nonZero = 0;
        int pointer = 0;
        while(pointer < nums.length){
            if(nums[pointer] != 0){
                int temp = nums[pointer];
                nums[pointer] = nums[nonZero];
                nums[nonZero] = temp;
                nonZero++;
            }
            pointer++;
        }
    }
}

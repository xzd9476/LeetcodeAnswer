package com.example.mvcdemo.test;


/**
 * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
 *
 * 示例 1：
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 *
 * 来源：力扣（LeetCode）
 * 难度：中等。
 * 链接：https://leetcode-cn.com/problems/sort-colors
 */

/**
 * 经典的荷兰国旗问题。使用3指针解法，指针0表示值为0的元素的位置，指针1表示值为1的元素的位置，指针i表示遍历数组到达的位置。
 * 遍历数组，如果找到1，就跟指针1位置的值互换
 * 如果找到0，需要注意0值互换会把1换出去。所以要判断p1 > p0。并且交换后p0++ p1++
 */
public class D_SortColors {
    public void sortColors(int[] nums) {
        int pointer0 = 0;
        int pointer1 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                swap(nums,pointer0,i);
                if(pointer0 < pointer1){
                    swap(nums,pointer1,i);
                }
                pointer1++;
                pointer0++;
            }else if(nums[i] == 1){
                swap(nums,pointer1,i);
                pointer1++;
            }
        }
    }

    public void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

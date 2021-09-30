package com.example.mvcdemo.test;


/**
 * 4. 寻找两个正序数组的中位数Hard
 * 题目描述：给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */

/**
 * 思路：
 * 解法1.先合并两个数组，然后对合并后的数组取中间值；
 * 解法2.使用大堆和小堆，当前为奇数个时，先放入小堆然后从大堆poll最小的放到大堆；当前为偶数个时，先放入大堆然后从大堆poll最大的放到小堆；最后根据奇偶性从两个堆里面取数；
 * 解法3.遍历两个数组，用right和left记录当前最小值和上一个最小值。 当遍历到len/2的时候，说明已经找到了中文数
 */

//解法3的代码如下：
public class B_FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int right=0;
        int left = 0;
        int len = nums1.length + nums2.length;
        int n1 = 0;
        int n2 = 0;
        for(int i=0;i<= len/2;i++){
            int temp = 0;
            if(n1 <nums1.length && n2< nums2.length){
                if(nums1[n1] < nums2[n2]){
                    temp = nums1[n1++];
                }else{
                    temp = nums2[n2++];
                }
            }else if(n1!=nums1.length){
                temp = nums1[n1++];
            }else{
                temp = nums2[n2++];
            }
            left = right;
            right = temp;
        }
        if(len%2 == 0){
            return ((double)(right+left))/2;
        }else{
            return (double)right;
        }
    }
}

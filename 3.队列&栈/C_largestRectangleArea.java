package com.example.mvcdemo.test.c队列和栈;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为 10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 难度：hard
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 */

/**
 * 思路1：使用暴力算法，对每个i元素，从i出发向左遍历向右遍历，找出每个i的高度区间。时间复杂度n平方
 * 思路2：使用动态规划，使用int[] leftBorder 和 int[] rightBorder来保存i元素的左右边界。对i+1号元素求边界的时候，与i比较，如果height[i+1] < height[i]，那直接那i+1元素与leftBorder[i]边界比较。省去一步步比较的步骤。
 *  ”因为你比我大，所以我一定能走到你的边界。走到你的边界后，如果我比边界小，那我走到边界的边界，直到-1位置。“
 * 思路3：使用单调栈。使用栈来保存元素下标，如果height[i] > height[i-1]。不做处理直接stack.push()；如果height[i]<height[i-1]，则说明可以划出矩形，通过while往回比较和计算。栈中的元素一定是高度顺序排列的。所以栈顶元素的左边界就是栈顶下一位元素，栈顶的右边界就是当前i。
 */
public class C_largestRectangleArea {
    //暴力算法
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            //当前柱子高度对应的最大面积
            int left = i;
            int right = i;
            for(;left>=0;left--){
                if(heights[left] < heights[i]) break;
            }
            for(;right<heights.length;right++){
                if(heights[right] < heights[i]) break;
            }
            int width = right - left - 1;
            int currentAreaSize = heights[i] * width;
            maxArea = Math.max(maxArea,currentAreaSize);
        }
        return maxArea;
    }

    //动态规划
    public int largestRectangleArea2(int[] heights) {
        int[] borderLeft = new int[heights.length];
        int[] borderRight = new int[heights.length];
        //先寻找左边界
        for(int i=0;i<heights.length;i++){
            int t = i-1;
            while(t>=0 && heights[i] <= heights[t]){
                t = borderLeft[t];
            }
            borderLeft[i] = t;
        }

        //寻找右边界
        for(int i=heights.length-1;i>=0;i--){
            int t = i+1;
            while(t<heights.length && heights[i] <= heights[t]){
                t = borderRight[t];
            }
            borderRight[i] = t;
        }

        //计算每个柱子的最大面积
        int res = 0;
        for(int i=0;i<heights.length;i++){
            int width = borderRight[i] - borderLeft[i] -1;
            int size = width * heights[i];
            res = Math.max(res,size);
        }
        return res;
    }

    //单调栈
    public int largestRectangleArea3(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();

        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下表1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下表
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}

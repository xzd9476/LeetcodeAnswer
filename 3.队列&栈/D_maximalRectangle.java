package com.example.mvcdemo.test.c队列和栈;

import java.util.Stack;

/**
 * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 *
 * 难度：hard
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 */

/**
 * 思路：单调栈，类似于“柱状图中最大矩形面积”一题。可以把每一行当作一组height然后求得每一行得最大矩形，然后不断增加行，不断更新height，求的每一行作为最底层的最大矩形，再求这些值的最大值就是返回的结果
 */
public class D_maximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length<1 || matrix[0].length<1){
            return 0;
        }
        int[][] newArr = new int[matrix.length][matrix[0].length+2];
        for(int i=0;i<matrix.length;i++){//行
            for(int j=0;j<matrix[0].length;j++){//列
                if(matrix[i][j] == '1'){
                    newArr[i][j+1] = i > 0 ? (newArr[i-1][j+1]+1) : 1;
                }
            }
        }
        int res = 0;
        for(int i=0;i< newArr.length;i++){
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for(int j=0;j<newArr[0].length;j++){
                if(newArr[i][j] >= newArr[i][stack.peek()]){
                    stack.push(j);
                }else{
                    while(newArr[i][j] < newArr[i][stack.peek()]){
                        int mid = stack.peek();
                        stack.pop();
                        int left = stack.peek();
                        int right = j;
                        int width = right - left -1;
                        int size = width * newArr[i][mid];
                        res = Math.max(size,res);
                    }
                    stack.push(j);
                }
            }
        }
        return res;
    }
}

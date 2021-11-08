package com.example.mvcdemo.test.c队列和栈;

import java.util.Stack;

/**
 * 739. 每日温度
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 */

//思路：使用单调递减栈。如果当前元素比栈顶元素小，入栈，如果当前元素比栈顶元素大，则while循环弹出stack中的元素。
public class H_dailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.add(i);
            }else{
                while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    int t = stack.pop();
                    res[t] = i-t;
                }
                stack.add(i);
            }
        }
        return res;
    }
}

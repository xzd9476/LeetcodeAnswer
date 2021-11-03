package com.example.mvcdemo.test.c队列和栈;
import java.util.Stack;


/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop()—— 删除栈顶的元素。
 * top()— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 难度：Easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 */

//思路：使用两个Stack，stack1正常push(val)，stack2作为min栈，在push(val)的时候要比较val和stack2.peek()的大小。
public class E_MinStack {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public E_MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.size() == 0) {
            stack2.push(val);
        } else {
            int val2 = stack2.peek();
            stack2.push(val < val2 ? val : val2);
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}

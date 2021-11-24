package com.example.mvcdemo.test.e二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层级遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：[[3],[9,20],[15,7]]
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 */

/**
 * 解决：使用队列保存每一层级的Node，然后当队列不为空的时候，计算出队列长度，按长度遍历队列中的node，并将node的非空左右节点加入队列
 */
public class C_levelOrder {
    class TreeNode{
        TreeNode(int val){
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
        int val;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node!=null){
                    list.add(node.val);
                    if(node.left!=null) queue.add(node.left);
                    if(node.right!=null) queue.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

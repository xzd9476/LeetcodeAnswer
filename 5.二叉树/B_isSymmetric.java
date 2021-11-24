package com.example.mvcdemo.test.e二叉树;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * 难度：easy
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 解法1：使用递归；解法2：使用迭代
 */
public class B_isSymmetric {
    static class TreeNode{
        public TreeNode(int val){
            this.val =val;
        }
        TreeNode left;
        TreeNode right;
        int val;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.right = new TreeNode(3);
        node.right.left = new TreeNode(3);
        System.out.println(isSymmetric1(node));
    }
    //迭代
    public static boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root.left);
        queue2.add(root.right);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null || node1.val != node2.val){
                return false;
            }
            if(node2 ==null && node1!=null){
                return false;
            }
            queue1.add(node1.left);
            queue1.add(node1.right);
            queue2.add(node2.right);
            queue2.add(node2.left);
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }

    //递归
    public boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }

    public boolean isSymmetricHelper(TreeNode left,TreeNode right){
        if(left == null){
            return right == null;
        }
        if(right == null){
            return left == null;
        }
        if(left.val != right.val){
            return false;
        }
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }


}

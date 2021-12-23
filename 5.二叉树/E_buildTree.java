package com.example.mvcdemo.test.e二叉树;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
 *
 * 示例 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * 示例 2:
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 难度：medium
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 */

/**
 * 思路：递归
 * 前序遍历的形式是：根左右
 * 中序遍历的形式是：左根右
 * 所以可以通过前序遍历的首节点，来切分中序遍历，从而知道左右子树中的节点数目，根据这个数目再划分前序遍历。递归下去从而重构二叉树
 */
public class E_buildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0){
            return null;
        }
        return recursionHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode recursionHelper(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if(prestart > preend){
            return null;
        }
        TreeNode node = new TreeNode(preorder[prestart]);
        for(int i=instart;i<=inend;i++){
            if(inorder[i] == preorder[prestart]){
                node.left = recursionHelper(preorder,prestart+1,prestart+i-instart,inorder,instart,i-1);
                node.right = recursionHelper(preorder,prestart+i-instart+1,preend,inorder,i+1,inend);
            }
        }
        return node;
    }
}

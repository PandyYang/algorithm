package com.pandy.base.tree;

import com.pandy.common.TreeNode;


/**
 * @Author Pandy
 * @Date 2021/7/31 19:12
 * <p>
 * 创建一个二叉树
 */
public class BinaryTree {
    public TreeNode root = null;

    public TreeNode createBinaryTree(int[] arr, int index) {
        TreeNode treeNode = null;
        if (index < arr.length) {
            treeNode = new TreeNode(arr[index]);
            treeNode.left = createBinaryTree(arr, 2 * index + 1);
            treeNode.right = createBinaryTree(arr, 2 * index + 2);
        }
        return treeNode;
    }
}

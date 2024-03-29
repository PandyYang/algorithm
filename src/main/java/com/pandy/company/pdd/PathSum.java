package com.pandy.company.pdd;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/7/7
 * <p>
 * 路径总和III
 * <p>
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 **/
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = dfs(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int dfs(TreeNode root, int targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }

        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += dfs(root.left, targetSum - val);
        ret += dfs(root.right, targetSum - val);
        return ret;
    }
}

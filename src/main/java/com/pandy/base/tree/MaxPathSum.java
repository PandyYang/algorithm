package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/5/6
 **/
public class MaxPathSum {

    private int ret = Integer.MIN_VALUE;

    /**
     * 对于任意一个节点, 如果最大和路径包含该节点, 那么只可能是两种情况:
     * 1. 其左右子树中所构成的和路径值较大的那个加上该节点的值后向父节点回溯构成最大路径
     * 2. 左右子树都在最大路径中, 加上该节点的值构成了最终的最大路径
     **/
    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if (r == null) return 0;

        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));
        int right = Math.max(0, getMax(r.right));

        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        ret = Math.max(ret, r.val + left + right);
        return Math.max(left, right) + r.val;
    }
}

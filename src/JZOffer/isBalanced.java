package JZOffer;

import utils.TreeNode;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-20
 */
public class isBalanced {

    public boolean isBalanced(TreeNode root) {
        return help(root) != -1;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        if (left == -1) {
            return -1;
        }
        int right = help(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? 1 + Math.max(left, right) : -1;
    }
}

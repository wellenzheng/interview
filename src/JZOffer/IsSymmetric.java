package JZOffer;

import utils.TreeNode;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return help(root, root);
    }

    public boolean help(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return help(left.left, right.right) && help(left.right, right.left);
    }

}

package utils;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-04
 */
public class BSTree {
    TreeNode root;
    int count;

    public BSTree() {
        this.root = null;
    }

    public BSTree(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void insert(int val) {
        root = insertHelp(root, val);
        count++;
    }

    private TreeNode insertHelp(TreeNode node, int val) {
        if (node == null) {
            node = new TreeNode(val);
        } else if (val < root.val) {
            node.setLeft(insertHelp(node.left, val));
        } else {
            node.setRight(insertHelp(node.right, val));
        }
        return node;
    }

    public boolean contain(int val) {
        return containHelp(root, val);
    }

    private boolean containHelp(TreeNode node, int val) {
        if (node == null) {
            return false;
        } else if (val < node.val) {
            return containHelp(node.left, val);
        } else if (val > node.val) {
            return containHelp(node.right, val);
        } else {
            return true;
        }
    }

    public void delete(int val) {
        if (contain(val)) {
            root = deleteHelp(root, val);
            count--;
        }
    }

    private TreeNode deleteHelp(TreeNode node, int val) {
        if (node == null) {
            return null;
        } else if (val < node.val) {
            node.setLeft(deleteHelp(node.left, val));
        } else if (val > node.val) {
            node.setRight(deleteHelp(node.right, val));
        } else {
            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                TreeNode temp = getMin(node.right);
                node.setVal(temp.val);
                node.setRight(deleteMin(node.right));
            }
        }
        return node;
    }

    public TreeNode getMin(TreeNode node) {
        if (root.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        } else {
            node.setLeft(deleteMin(node.right));
        }
        return node;
    }
}

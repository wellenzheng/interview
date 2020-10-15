package ByteDance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-25
 */
public class levelOrder3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> nodes = new ArrayDeque<>();
        int level = 0;
        if (root != null) {
            nodes.add(root);
        }
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (level % 2 == 0) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            level++;
            lists.add(list);
        }
        return lists;
    }
}

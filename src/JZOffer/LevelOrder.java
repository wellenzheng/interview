package JZOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import javafx.util.Pair;
import utils.TreeNode;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedBlockingQueue<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> poll = queue.poll();
            if (poll.getValue() >= res.size()) {
                List<Integer> temp = new ArrayList<>();
                temp.add(poll.getKey().val);
                res.add(temp);
            } else {
                res.get(poll.getValue()).add(poll.getKey().val);
            }
            if (poll.getKey().left != null) {
                queue.add(new Pair<>(poll.getKey().left, poll.getValue() + 1));
            }
            if (poll.getKey().right != null) {
                queue.add(new Pair<>(poll.getKey().right, poll.getValue() + 1));
            }
        }
        return res;
    }
}

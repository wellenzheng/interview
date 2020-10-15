import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-09-06
 */
public class NotifyPeople {
    public static int notifyNum(List<Set<Integer>> list) {
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int[] visit = new int[list.size()];
        while (true) {
            int size = set.size();
            for (int i = 0; i < list.size(); i++) {
                for (int n : set) {
                    if (visit[i] != 1 && list.get(i).contains(n)) {
                        set.addAll(list.get(i));
                        visit[i] = 1;
                    }
                }
            }
            if (size == set.size()) {
                return size;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            Set<Integer> s = new HashSet<>();
            for (int j = 0; j < num; j++) {
                s.add(scanner.nextInt());
            }
            list.add(s);
        }
        System.out.println(notifyNum(list));
    }
}

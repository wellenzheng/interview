import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SelectRole {
    public static List<List<Integer>> lists = new ArrayList<>();

    public static void help(int[] people, int[] role) {
        Integer[] list = new Integer[people.length];
        int[] hash = new int[101];
        for (int value : role) {
            hash[value]++;
        }
        for (int i = 100; i >= 1; i--) {
            hash[i - 1] += hash[i];
        }
        for (int i = 0; i < people.length; i++) {
            list[i] = hash[people[i]];
        }
        lists.add(Arrays.asList(list));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        List<int[]> pl = new ArrayList<>(t);
        List<int[]> rl = new ArrayList<>(t);

        while (t > 0) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            int[] people = new int[n];
            int[] role = new int[m];
            for (int i = 0; i < n; i++) {
                people[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                role[i] = scanner.nextInt();
            }
            pl.add(people);
            rl.add(role);
            t--;
        }
        for (int i = 0; i < pl.size(); i++) {
            help(pl.get(i), rl.get(i));
        }
        for (List<Integer> list : lists) {
            System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
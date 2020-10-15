import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import javafx.util.Pair;

public class Main {

    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] output = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.addLast(i);
        }
        for (int i = k; i < nums.length; i++) {
            queue.pollFirst();
            queue.removeIf(integer -> integer < nums[queue.peekLast()]);
            queue.addLast(i);
            output[index++] = nums[queue.peekFirst()];
        }
        return output;
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B', 'C'};
        System.out.println();
    }

}
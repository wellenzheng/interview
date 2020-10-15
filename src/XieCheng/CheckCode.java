package XieCheng;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CheckCode {

    public static Map<String, int[]> map = new HashMap<>();

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static int validateArrayUsages(String[] lines) {
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].contains("=")) {
                String name = lines[i].substring(0, lines[i].indexOf('['));
                int length = Integer.parseInt(lines[i].substring(lines[i].indexOf('[') + 1, lines[i].length() - 1));
                int[] arr = new int[length];
                map.put(name, arr);
            } else {
                String[] split = lines[i].split("=");
                String name = split[0].substring(0, split[0].indexOf('['));
                String sub = split[0].substring(split[0].indexOf('[') + 1, split[0].length() - 1);
                int index = getValue(sub);
                int value = getValue(split[1]);

                try {
                    map.get(name)[index] = value;
                } catch (IndexOutOfBoundsException e) {
                    return i + 1;
                }
            }
        }
        return 0;
    }

    public static int getValue(String s) throws IndexOutOfBoundsException {
        if (s.matches("-?[0-9]+")) {
            return Integer.parseInt(s);
        }
        String name = s.substring(0, s.indexOf('['));
        String sub = s.substring(s.indexOf('[') + 1, s.length() - 1);
        if (Character.isDigit(sub.charAt(0))) {
            int i = Integer.parseInt(sub);
            return map.get(name)[i];
        } else {
            return getValue(sub);
        }
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _lines_size = 0;
        _lines_size = Integer.parseInt(in.nextLine().trim());
        String[] _lines = new String[_lines_size];
        String _lines_item;
        for (int _lines_i = 0; _lines_i < _lines_size; _lines_i++) {
            try {
                _lines_item = in.nextLine();
            } catch (Exception e) {
                _lines_item = null;
            }
            _lines[_lines_i] = _lines_item;
        }

        res = validateArrayUsages(_lines);
        System.out.println(String.valueOf(res));

    }
}

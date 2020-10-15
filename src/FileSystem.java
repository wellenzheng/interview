import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class FileSystem {

    private static int fd = 0;
    private static Map<String, String> map = new HashMap<>();
    private static List<String> list = new ArrayList<>();

    public static void operate(String op, String param1, String param2) {
        if ("open".equals(op)) {
            if (map.containsValue(param1)) {
                map.forEach((k, v) -> {
                    if (param1.equals(v)) {
                        list.add(k);
                    }
                });
                return;
            }
            while (map.get(String.valueOf(fd)) != null) {
                fd++;
            }
            map.put(String.valueOf(fd), param1);
            list.add(String.valueOf(fd++));
        } else if ("dup".equals(op)) {
            String file = map.get(param1);
            while (map.get(String.valueOf(fd)) != null) {
                fd++;
            }
            map.put(String.valueOf(fd), file);
            list.add(String.valueOf(fd++));
        } else if ("dup2".equals(op)) {
            String file = map.get(param1);
            map.put(param2, file);
            //            fileList[Integer.parseInt(param2)] = fileList[Integer.parseInt(param1)];
        } else if ("close".equals(op)) {
            map.replace(param1, null);
            fd = Math.min(fd, Integer.parseInt(param1));
            //            fileList[Integer.parseInt(param1)] = null;
        } else if ("query".equals(op)) {
            list.add(map.get(param1));
            //            list.add(fileList[Integer.parseInt(param1)]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            for (int j = 0; j < n; j++) {
                String line = scanner.nextLine();
                String[] split = line.split(" ");
                String op = split[0], param1 = split[1], param2 = split.length == 3 ? split[2] : null;
                operate(op, param1, param2);
            }
            fd = 0;
            map.clear();
        }
        System.out.println(String.join("\n", list));
    }
}
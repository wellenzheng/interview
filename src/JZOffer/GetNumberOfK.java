package JZOffer;

/**
 * @author zhengweijun <zhengweijun@kuaishou.com>
 * Created on 2020-08-01
 */
public class GetNumberOfK {

    public static int search(int[] num, int target) {
        int first = findFirst(num, target);
        int last = findLast(num, target);
        return first == -1 || last == -1 ? 0 : last - first + 1;
    }

    public static int findFirst(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                if (mid - 1 >= 0 && num[mid - 1] < target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return num[left] == target ? left : -1;
    }

    public static int findLast(int[] num, int target) {
        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (num[mid] > target) {
                right = mid - 1;
            } else if (num[mid] < target) {
                left = mid + 1;
            } else {
                if (mid + 1 < num.length && num[mid + 1] > target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return num[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        int[] num = {3, 3, 3, 3};
        System.out.println(search(num, 9));
    }
}

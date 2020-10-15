package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class MinArray {

    public static int minArray(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }
        int left = 0, right = numbers.length - 1, mid = left;
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) / 2;
            if (numbers[left] == numbers[mid] && numbers[mid] == numbers[right]) {
                return linear(numbers, left, right);
            }
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    public static int linear(int[] numbers, int left, int right) {
        int min = numbers[left];
        for (int i = left; i <= right; i++) {
            if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {

    }

}

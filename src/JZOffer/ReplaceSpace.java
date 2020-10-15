package JZOffer;

/**
 * @author zhengweijun
 * Created on 2020-07-19
 */
public class ReplaceSpace {

    public static String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}

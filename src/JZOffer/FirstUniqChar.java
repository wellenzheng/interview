package JZOffer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author zhengweijun
 * Created on 2020-07-20
 */
public class FirstUniqChar {

    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return ' ';
        }
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] == 1) {
                return s.charAt(hash[i]);
            }
        }
        return ' ';
    }

    public static LocalDateTime convertDateToLocalDateTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static Date convertLocalDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(Instant.from(localDateTime.atZone(ZoneId.systemDefault())));
    }

    public static void main(String[] args) {
        int MS = 1000 * 60 * 60 * 24;
        System.out.println(1000 * 60 * 60 * 24);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JULY, 19, 0, 0, 0);
        Date time1 = calendar.getTime();
        calendar.set(2020, Calendar.JULY, 15, 0, 0, 0);
        Date time2 = calendar.getTime();
        List<LocalDateTime> list = new ArrayList<>();
        list.add(convertDateToLocalDateTime(time1));
        list.add(convertDateToLocalDateTime(time2));
        System.out.println(Collections.min(list));
    }
}

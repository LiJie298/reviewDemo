package java8;


import org.jsoup.Jsoup;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeDemo {

    static Pattern pattern = Pattern.compile("content :'[\\s\\S]+?'", Pattern.CASE_INSENSITIVE);



//    public static void main(String[] args) {
//        try {
//            String html = Jsoup.connect("https://www.toutiao.com/a6673398428485026052").get().html();
//            Matcher matcher = pattern.matcher(html);
//            if (matcher.find()) {
//                System.out.println(matcher.group());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        LocalDate today = LocalDate.now();
//        System.out.println(getDateString(today, "yyyy-MM-dd"));
//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(getDateString(now, "yyyy-MM-dd HH:mm:ss"));
//    }


    public static void main(String[] args){
        Father father = new Father("1","2");
        Father father1 = new Father("2","3");
        Father father2 = new Father("3","4");
        System.out.println(father.get_serviceKey());
        System.out.println(father1.get_serviceKey());
        System.out.println(father2.get_serviceKey());
    }

    /**
     * 获取时间的字符串形态
     *
     * @param date
     * @param dataFormat
     * @param <T>
     * @return
     */
    public static <T> String getDateString(T date, String dataFormat) {
        String dateStr = "";
        if (date.getClass().isInstance(LocalDate.class)) {
            dateStr = ((LocalDate) date).format(DateTimeFormatter.ofPattern(dataFormat));
        } else if (date.getClass().isInstance(LocalDateTime.class)) {
            dateStr = ((LocalDateTime) date).format(DateTimeFormatter.ofPattern(dataFormat));
        } else if (date.getClass().isInstance(LocalTime.class)) {
            dateStr = ((LocalTime) date).format(DateTimeFormatter.ofPattern(dataFormat));
        }
        return dateStr;
    }

    /**
     * 获取月份
     */
    public static void getMouth() {
        for (Month month : Month.values()) {
            System.out.printf("%s - %s %n", month.getDisplayName(TextStyle.FULL, Locale.CHINA), month.getValue());
        }
    }

    /**
     * 获取时间戳
     *
     * @param date
     * @param <T>
     * @return
     */
    public static <T> long getDateLong(T date) {
        long dateLong = 0l;
        if (date.getClass().isInstance(LocalDate.class)) {
//            ((LocalDate) date).get();
//        } else if (date.getClass().isInstance(LocalDateTime.class)) {

        }
        return dateLong;
    }

}

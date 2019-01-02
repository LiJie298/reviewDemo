package java8.time8;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

import static org.apache.commons.lang3.time.DateUtils.MILLIS_PER_DAY;

public class DateUtil {

    public static final String NOR_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String NOR_DATE = "yyyy-MM-dd";
    public static final String NOR_TIME = "HH:mm:ss";

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(getDateString(today, NOR_DATE));
        LocalDateTime now = LocalDateTime.now();
        System.out.println("--" + getDateString(getTodayZeroTime(), NOR_DATE_TIME));
    }

    public static LocalDateTime getTodayZeroTime() {
//        还有时区问题
//        long current = System.currentTimeMillis();
//        long zeroLong = current - current % MILLIS_PER_DAY;
//        return getLocalDateTime(zeroLong);
        return LocalDateTime.of(LocalDate.now(),LocalTime.MIN);
    }


    /**
     * @param date
     * @param <T>
     * @return
     */
    public static <T> String getNorString(T date) {
        String dateStr = "";
        if (date.getClass().isInstance(LocalDate.class)) {
            dateStr = ((LocalDate) date).format(DateTimeFormatter.ofPattern(NOR_DATE));
        } else if (date.getClass().isInstance(LocalDateTime.class)) {
            dateStr = ((LocalDateTime) date).format(DateTimeFormatter.ofPattern(NOR_DATE_TIME));
        } else if (date.getClass().isInstance(LocalTime.class)) {
            dateStr = ((LocalTime) date).format(DateTimeFormatter.ofPattern(NOR_TIME));
        }
        return dateStr;
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
        if (date.getClass() == LocalDate.class) {
            dateStr = ((LocalDate) date).format(DateTimeFormatter.ofPattern(dataFormat));
        } else if (date.getClass() == LocalDateTime.class) {
            dateStr = ((LocalDateTime) date).format(DateTimeFormatter.ofPattern(dataFormat));
        } else if (date.getClass() == LocalTime.class) {
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
     * @return
     */
    public static long getDateLong(LocalDateTime date) {
        Instant instant = date.atZone(ZoneId.systemDefault()).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 时间戳获取LocalDatetime
     *
     * @param time
     * @return
     */
    public static LocalDateTime getLocalDateTime(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * 获取
     *
     * @param timeStr
     * @param format
     * @return
     */
    public static LocalDateTime getLocalDateTime(String timeStr, String format) {
        LocalDateTime localDateTime = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern(format));
        return localDateTime;
    }

    /**
     * 获取localDate时间对应的Date
     *
     * @param localDate
     * @param <T>
     * @return
     */
    public static <T> Date parseDate(T localDate) {
        ZonedDateTime zonedDateTime = null;
        if (localDate.getClass().isInstance(LocalDate.class)) {
            zonedDateTime = ((LocalDate) localDate).atStartOfDay(ZoneId.systemDefault());
        } else if (localDate.getClass().isInstance(LocalDateTime.class)) {
            zonedDateTime = ((LocalDateTime) localDate).atZone(ZoneId.systemDefault());
        }
        return Date.from(zonedDateTime.toInstant());
    }


}

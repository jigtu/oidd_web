package cn.com.cintel.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author ZiQiang
 * @date 2019/1/7 10:00
 * 描述： <p>请写明本类的作用</p>
 */
public class DateUtils {

    public static Date stringToDate(String date, String patten) {
        if (date.length() == 10) {
            date = date + " 00:00:00";
            patten = "yyyy-MM-dd HH:mm:ss";
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(patten);
        LocalDateTime parse = LocalDateTime.parse(date, formatter);
        return Date.from(parse.atZone(ZoneId.systemDefault()).toInstant());
    }
}

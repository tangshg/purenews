package my.hhx.com.chunnews.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.data;
import static android.R.attr.format;

/**
 * Created by hhx on 2017/10/20.
 *
 * @author hhx
 */

public class DateUtils {
    private static final long ONE_MINUTE = 1000 * 60L;
    private static final long ONE_HOUR = 1000 * 60 * 60L;
    private static final long ONE_DAY = 1000 * 60 * 60 * 24L;
    private static final long ONE_MONTH = 1000 * 60 * 60 * 24 * 30L;
    private static final String BEFORE_MINUTE = "分钟前";
    private static final String BEFORE_HOUR = "小时前";
    private static final String BEFORE_DAY = "天前";
    private static final String BEFORE_MONTH = "月前";
    private static final String BEFORE_YEAR = "超过一年";

    /**
     * 计算日期格式时间与系统时间的时间戳差值
     */
    public static long date2Delta(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long delta = 0L;
        try {
            Log.e("222", String.valueOf(format.parse(date).getTime()));
            delta = new Date().getTime() - format.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return delta;
    }

    public static long timeStamp2Delta(long date) {

        long delta;
        delta = new Date().getTime() - date;
        return delta;
    }

    public static long date2Delta(Date date) {

        long delta;
        delta = new Date().getTime() - date.getTime();
        return delta;
    }

    /**
     * 换算成当前时间的前几(分钟，小时，天，月)
     */
    public static String date2RelativeTime(String data) {
        long detal = date2Delta(data);
        String relativeTime = delta2RelativeTime(detal);
        return relativeTime;

    }

    public static String date2RelativeTime(Date data) {
        long delta = date2Delta(data);
        String relativeTime = delta2RelativeTime(delta);
        return relativeTime;

    }

    public static String timeStamp2RelativeTime(long timeStamp) {
        long delta = timeStamp2Delta(timeStamp);
        String relativeTime = delta2RelativeTime(delta);
        return relativeTime;

    }

    private static String delta2RelativeTime(long delta) {
        Log.e("delta", String.valueOf(delta));
        if ((delta / ONE_MINUTE) < 60) {
            return delta / ONE_MINUTE + BEFORE_MINUTE;
        }
        if ((delta / ONE_HOUR) < 24) {
            return delta / ONE_HOUR + BEFORE_HOUR;
        }
        if ((delta / ONE_DAY) < 30) {
            return delta / ONE_DAY + BEFORE_DAY;
        }
        if ((delta / ONE_MONTH) < 12) {
            return delta / ONE_MONTH + BEFORE_MONTH;
        }

        return BEFORE_YEAR;
    }

}

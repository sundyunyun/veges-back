package dhu.sun.vege.util;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * 中国周,一周的第一天是星期一,最后一天是星期天
 *
 * @author Tan Jie
 * @date 2017/11/15
 */

public class DateTools {
    private static final long DAY_MILLIS = 1000 * 60 * 60 * 24;


    /**
     * 当前时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date base;

    /**
     * 一周的第一天的日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date firstDay;

    /**
     * 一周的最后一天的日期
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date lastDay;

    private Integer year;

    private Integer month;

    private Integer day;

    /**
     * 当前日期是该月的第几周
     */
    private Integer week;

    public DateTools() {
    }

    public DateTools(Date time) {
        this(time, 0);
    }

    public DateTools(Date time, int offset) {
        this.setTime(time, offset);
    }


    public void setTime(Date time) {
        this.setTime(time, 0);
    }

    public void setTime(Date time, int offset) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        base = time;
        cal.setTime(base);
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        day = cal.get(Calendar.DAY_OF_MONTH);
        int t = cal.get(Calendar.DAY_OF_WEEK) - 2;
        t = t < 0 ? 6 : t;
        firstDay = new Date(base.getTime() + (7 * offset - t) * DAY_MILLIS);
        lastDay = new Date(base.getTime() + (7 * offset + 6 - t) * DAY_MILLIS);
        try {
            firstDay = sdf.parse(sdf1.format(firstDay) + " 00:00:00 000");
            lastDay = sdf.parse(sdf1.format(lastDay) + " 23:59:59 999");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.set(year, month - 1, 1);
        int d = cal.get(Calendar.DAY_OF_WEEK) - 1;
        d = d < 1 ? 7 : d;
        week = 1 + (day + d - 2) / 7;
    }

    public int getOffset(Date targetTime, Date baseTime) {
        if (targetTime == null || baseTime == null)
            return 0;
        setTime(targetTime);
        Date d1 = firstDay;
        setTime(baseTime);
        Date d2 = firstDay;
        return (int) ((d1.getTime() - d2.getTime()) / DAY_MILLIS / 7);
    }

    public Date getBase() {
        return base;
    }

    public Date getFirstDay() {
        return firstDay;
    }

    public Date getLastDay() {
        return lastDay;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }

    public Integer getWeek() {
        return week;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "week information{ " +
                "now=" + sdf.format(base) +
                ", week of month=" + week +
                ", firstDay=" + sdf.format(firstDay) +
                ", lastDay=" + sdf.format(lastDay) +
                " }";
    }
}

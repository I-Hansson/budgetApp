package org.chalmers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateStringFormatter {

    public static String getFormattedDate(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format(date.getTime());
    }

    public static String getDayOfWeekAsString(Calendar date) {
        String[] days =
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        int day = date.get(Calendar.DAY_OF_WEEK);
        return days[day-1];
    }
}

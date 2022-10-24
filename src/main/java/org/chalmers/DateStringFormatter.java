package org.chalmers;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Comprehends the object date.
 * @author William
 */

public class DateStringFormatter {

    /**
     * Extract the date in to a string in a simpler format.
     * @param date The date object.
     * @return The date object remade to a string of simple format.
     */
    public static String getFormattedDate(Calendar date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        return sdf.format(date.getTime());
    }

    /**
     * Extracts the day of the date and return it as a string.
     * @param date The date object.
     * @return The date object remade to a string of the date's day.
     */

    public static String getDayOfWeekAsString(Calendar date) {
        String[] days =
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",};
        int day = date.get(Calendar.DAY_OF_WEEK);
        return days[day-1];
    }

    /**
     * Extracts the month of the date and return it as a string.
     * @param date The date object.
     * @return The date object remade to string of the date's month.
     */

    public static String getMonthAsString(Calendar date) {
        String[] month =
                {"January", "February", "Mars", "April", "May", "June", "July", "August", "September",
                        "October", "November", "December"};
        return month[date.get(Calendar.MONTH)];
    }
}

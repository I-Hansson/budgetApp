package org.chalmers.model;

import java.util.Calendar;

/**
 * An interface for classes which feature a Calendar object representing a date
 *
 * @author williamfrisk
 */
public interface IHasDate {

    /**
     * Returns a calendar representing a fixed date.
     * @return The calendar object
     */
    Calendar getDate();
}

/*
 * version:
 * date:
 * by Christian Graumann
 */

package app.layerLogic.cmpConsulting.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Hilfsklasse für Java Date
 */
public class DateUtil {

    private static final int DAY_HOURS = 24;
    private static final int DAY_SECONDS = 3600;
    private static final int DAY_MILLISECONDS = 1000;
    private static final int ONE_DAY_IN_MILLISECONDS = DAY_HOURS * DAY_SECONDS * DAY_MILLISECONDS;

    public static Date now(){
        return Calendar.getInstance(Locale.GERMANY).getTime();
    }

    public static Date yesterday(){
        return new Date(DateUtil.now().getTime() - ONE_DAY_IN_MILLISECONDS);
    }

    public static Date tomorrow(){
        return new Date(DateUtil.now().getTime() + ONE_DAY_IN_MILLISECONDS);
    }

    public static Date aferTomorrow(){
        return new Date(DateUtil.now().getTime() + (2 * ONE_DAY_IN_MILLISECONDS));
    }

    public static String excractDate(Date date){
        SimpleDateFormat dateFormatterQueryParam = new SimpleDateFormat("yyyy-MM-dd");

        return dateFormatterQueryParam.format(date);
    }

    public static String excractDateAndTime(Date date){
        SimpleDateFormat dateFormatterQueryParam = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return dateFormatterQueryParam.format(date);
    }

    public static Date getDate(String dateAndTime){

        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateAndTime);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }




}

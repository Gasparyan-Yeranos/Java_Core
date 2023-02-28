package homework.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat SDTF = new SimpleDateFormat("hh:mm");
    public static String dateToString(Date date){
        if(date == null){
            return null;
        }
        return SDF.format(date);
    }
    public static String dateTimeToString(Date date){
        if(date == null){
            return null;
        }
        return SDTF.format(date);
    }
    public static Date stringToDate(String date) throws ParseException {
        if(date == null){
            return null;
        }
        return SDF.parse(date);
    }
    public static Date stringTimeToDate(String date) throws ParseException {
        if(date == null){
            return null;
        }
        return SDTF.parse(date);
    }
    public static boolean isSameDate(Date date1, Date date2) {
        return (dateToString(date1).equals(dateToString(date2)));
    }

}

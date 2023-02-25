package homework.employee.util;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
    public static String dateToString(Date date){
        if(date == null){
            return null;
        }
        return SDF.format(date);
    }
    public static Date stringToDate(String date) throws ParseException {
        if(date == null){
            return null;
        }
        return SDF.parse(date);
    }
}

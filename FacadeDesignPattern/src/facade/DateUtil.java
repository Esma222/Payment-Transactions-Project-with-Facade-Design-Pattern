package facade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static Date currentlyDate(){

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        String dateStr = format.format(new Date());
        try {
            Date date = format.parse(dateStr);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    public  static long numberOfDaysCalculator(Date firstDate, Date lastDate){
        long coefficientOfDay =24*60*60*1000;
        long first = firstDate.getTime();
        long last = lastDate.getTime();

        long numberOfDaysCalculator = (last/coefficientOfDay)-(first/coefficientOfDay);

        return numberOfDaysCalculator;

    }
    public static  Long dateYear(Date date){
        String yearStr = new SimpleDateFormat("yyyy").format(date);
        return Long.valueOf(yearStr);
    }
    public static  Long dateMonth(Date date){
        String monthStr = new SimpleDateFormat("MM").format(date);
        return Long.valueOf(monthStr);
    }

    public static Date makeDate(String dateStr) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        try {
            date = format.parse(dateStr);
            return  date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

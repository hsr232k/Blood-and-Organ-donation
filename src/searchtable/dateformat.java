package searchtable;

/*  -- This class is to perform operations that are associated with
       date's used in the project --
*/

import java.text.*;
import java.util.Calendar;

public class dateformat {
    public static DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
    public static Calendar cal=Calendar.getInstance();
    public static String current_date = dateFormat.format(cal.getTime());  
    public static String calculate(int n){
        String result_date="";
        try{
            cal.setTime(dateFormat.parse(current_date));
            cal.add(Calendar.DAY_OF_MONTH, n);
            result_date=dateFormat.format(cal.getTime());
        }catch(ParseException e)
        {
            System.out.println("+++"+e);
        }
        
        return result_date;
    }
    
}

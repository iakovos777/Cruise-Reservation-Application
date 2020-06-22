package cast.cruise.util;

import java.util.Calendar;


public class SystemDate {

   
    protected SystemDate() { }

    private static SimpleCalendar stub;


    
    public static void setStub(SimpleCalendar stubDate) {
        stub = stubDate;
    }

   
    public static void removeStub() {
        stub = null;
    }


    
    public static SimpleCalendar now() {
        return stub == null ? new SimpleCalendar(Calendar.getInstance()) : stub;
    }
}

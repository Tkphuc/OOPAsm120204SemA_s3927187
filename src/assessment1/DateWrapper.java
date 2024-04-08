package assessment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
/**
 * @author <Tran Kiem Phuc - s3927187>
 *
 */
/*
Date class guide https://www.geeksforgeeks.org/date-settime-method-in-java-with-examples/
DateFormat idea //https://www.baeldung.com/java-string-valid-date
Regex idea     //https://viettuts.vn/java/su-dung-regex-trong-java*/


public class DateWrapper{
    private Date date;
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private  DateFormat format = new SimpleDateFormat(DATE_FORMAT);
    private Matcher matcher;
    public DateWrapper(Date date){
        this.date = date;
    }
    public DateWrapper(){}
    public Date dateCreate(String date) {
        format.setLenient(false);//to enforce the user of correct input
        try{
            this.date = format.parse(date);
        }catch (ParseException e){
            System.out.println("Wrong date input");
        }
        return this.date;
    }

}

package assessment1;
//https://www.geeksforgeeks.org/date-settime-method-in-java-with-examples/
//https://www.baeldung.com/java-string-valid-date
//https://viettuts.vn/java/su-dung-regex-trong-java
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;



public class DateWrapper{
    private Date date;
    private static final String DATE_FORMAT = "dd/MM/yyyy";
    //private Pattern pattern = Pattern.compile("\\d{2}+\\/+\\d{2}+\\/+\\d{4}");
    private  DateFormat format = new SimpleDateFormat(DATE_FORMAT);
    private Matcher matcher;
    //regex: \d{2}+\/+\d{2}+\/+\d{4}
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

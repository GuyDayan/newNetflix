import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date {
    private int year;
    private int month;
    private int day;

    public Date() {
        Calendar calendar = new GregorianCalendar();
        java.util.Date curr_date = new java.util.Date();
        calendar.setTime(curr_date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public Date(int year , int month , int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return this.day + "/" + this.month +"/" + this.year;
    }

}
